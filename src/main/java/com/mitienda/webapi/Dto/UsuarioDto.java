package com.mitienda.webapi.Dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioDto {

	private int idUsuario;
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String direccion;
	private String celular;
	private String correo;
	private String estado;
	private LocalDateTime fechaCreacion;
	private String usuarioCreacion;
	private String estacionCreacion;
	private LocalDateTime fechaModificacion;
	private String usuarioModificacion;
	private String estacionModificacion;
}