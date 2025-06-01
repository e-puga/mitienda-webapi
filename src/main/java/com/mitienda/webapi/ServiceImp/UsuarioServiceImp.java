package com.mitienda.webapi.ServiceImp;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mitienda.webapi.Dto.AuthRespuestaDto;
import com.mitienda.webapi.Dto.LoginDto;
import com.mitienda.webapi.Dto.UsuarioDto;
import com.mitienda.webapi.Entity.Rol;
import com.mitienda.webapi.Entity.Usuario;
import com.mitienda.webapi.Repository.RolRepository;
import com.mitienda.webapi.Repository.UsuarioRepository;
import com.mitienda.webapi.Security.JwtGenerator;
import com.mitienda.webapi.Service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements IUsuarioService {

	private ServicioDetalleUsuario _servicioDetalleUsuario;
	private UsuarioRepository _usuarioRepository;
	private RolRepository _rolRepository;
	private AuthenticationManager _authenticationManager;
	private PasswordEncoder _passwordEncoder;
	private JwtGenerator _jwtGenerator;

	public UsuarioServiceImp(ServicioDetalleUsuario servicioDetalleUsuario, UsuarioRepository usuarioRepository,
			RolRepository rolRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			JwtGenerator jwtGenerator) {
		this._servicioDetalleUsuario = servicioDetalleUsuario;
		this._usuarioRepository = usuarioRepository;
		this._rolRepository = rolRepository;
		this._authenticationManager = authenticationManager;
		this._passwordEncoder = passwordEncoder;
		this._jwtGenerator = jwtGenerator;
	}

	@Override
	public int GuardarUsuario(UsuarioDto usuario) {
		ModelMapper modelMapper = new ModelMapper();
		// int idUsuario = 0;

		try {

			Usuario respuesta = _usuarioRepository.findByUsername(usuario.getUsername()).orElse(new Usuario());

			// Configura el mapeo personalizado
			modelMapper.typeMap(UsuarioDto.class, Usuario.class)
					.addMappings(mapper -> mapper.skip(Usuario::setIdUsuario));
			modelMapper.map(usuario, respuesta); // Mapear del DTO a la entidad

			Rol rol = _rolRepository.findByNombre("ADMIN").get();
			respuesta.setRol(rol);

			if (respuesta == null || respuesta.getIdUsuario() == 0) {
				respuesta.setFechaCreacion(LocalDateTime.now());
				respuesta.setUsuarioCreacion(usuario.getUsuarioCreacion());
				respuesta.setEstacionCreacion(usuario.getEstacionCreacion());
			} else {
				respuesta.setFechaModificacion(LocalDateTime.now());
				respuesta.setUsuarioModificacion(usuario.getUsuarioModificacion());
				respuesta.setEstacionModificacion(usuario.getEstacionModificacion());
			}

			return _usuarioRepository.save(respuesta).getIdUsuario();

		} catch (Exception ex) {
			throw new RuntimeException("Error al guardar usuario" + ex.getMessage());
		}
		// return idUsuario;
	}

	@Override
	public List<UsuarioDto> ListarUsuario() {
		// ModelMapper modelMapper = new ModelMapper();
		try {
			List<Usuario> respuesta = _usuarioRepository.findAll();
			return new ModelMapper().map(respuesta, new TypeToken<List<UsuarioDto>>() {
			}.getType());

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener los usuarios" + ex.getMessage());
		}
	}

	public AuthRespuestaDto login(LoginDto login) {
		// Autenticar al usuario con el AuthenticationManager
		Authentication authentication = _authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

		// Establecer el contexto de seguridad
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Generar token JWT
		String token = _jwtGenerator.generarToken(login.getUsername());

		// Devolver respuesta con el token
		return new AuthRespuestaDto(token);
	}

	/*
	 * @Override public List<UsuarioDto> ListarUsuarioPaginacion(int numeroPagina,
	 * int medidaPagina) { // ModelMapper modelMapper = new ModelMapper(); try {
	 * Pageable pageable = PageRequest.of(numeroPagina, medidaPagina); Page<Usuario>
	 * usuario = _usuarioRepository.findAll(pageable);
	 * 
	 * List<Usuario> respuesta = usuario.getContent(); return new
	 * ModelMapper().map(respuesta, new TypeToken<List<UsuarioDto>>() {
	 * }.getType());
	 * 
	 * } catch (Exception ex) { throw new
	 * RuntimeException("Error al obtener los usuarios" + ex.getMessage()); } }
	 */

}
