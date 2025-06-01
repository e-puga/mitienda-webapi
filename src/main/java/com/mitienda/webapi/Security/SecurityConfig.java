package com.mitienda.webapi.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mitienda.webapi.ServiceImp.ServicioDetalleUsuario;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private ServicioDetalleUsuario servicioDetalleUsuario;
	// private final ManejoError failureHandler;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	public DaoAuthenticationProvider proveedorAutenticacion() {
		DaoAuthenticationProvider proveedor = new DaoAuthenticationProvider();
		proveedor.setUserDetailsService(servicioDetalleUsuario);
		proveedor.setPasswordEncoder(codificadorPassword());
		return proveedor;
	}

	@Bean
	@Order(1) // Orden para manejar multiples filtros
	public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {

		http.securityMatcher("/api/**") // Aplica esta configuración solo a /api/**
				.csrf(csrf -> csrf.disable()) // Desactiva CSRF (común para APIs)
				.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/api/usuario/**").authenticated().anyRequest().permitAll());

		// Agrega el filtro JWT personalizado antes del filtro de autenticación por
		// username/password
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder codificadorPassword() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

}
