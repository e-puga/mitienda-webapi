package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mitienda.webapi.Entity.Rol;
import com.mitienda.webapi.Entity.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.JoinColumn;

@Data
@Table(name = "Usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "celular")
	private String celular;

	@Column(name = "correo")
	private String correo;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "usuarioCreacion")
	private String usuarioCreacion;

	@Column(name = "estacionCreacion")
	private String estacionCreacion;

	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;

	@Column(name = "usuarioModificacion")
	private String usuarioModificacion;

	@Column(name = "estacionModificacion")
	private String estacionModificacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idRol")
	private Rol rol;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Set.of(new SimpleGrantedAuthority(rol.getNombre()));
	}

	/*
	 * @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "UsuarioRol", joinColumns = @JoinColumn(name =
	 * "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idRol",
	 * referencedColumnName = "idRol")) private List<Role> roles = new
	 * ArrayList<>();
	 */

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
