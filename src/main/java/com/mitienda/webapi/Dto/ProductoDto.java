package com.mitienda.webapi.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

	private int idProducto;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String talla;
	private Double descuento;
	private int idSubCategoriaProducto;
	private String marca;
	private Double precio;
	private String estado;
	private LocalDateTime fechaCreacion;
	private String estacionCreacion;
	private String usuarioCreacion;
	private LocalDateTime fechaModificacion;
	private String estacionModificacion;
	private String usuarioModificacion;
}
