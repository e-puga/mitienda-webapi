package com.mitienda.webapi.Dto;

import lombok.Data;

@Data
public class RolDto {
	private int idRol;
	private String nombre;
	private String descripcion;
	private String estado;
}