package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "CategoriaProducto")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoriaProducto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoriaProducto;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "estacionCreacion")
	private String estacionCreacion;

	@Column(name = "usuarioCreacion")
	private String usuarioCreacion;

	@Column(name = "fechaModificacion")
	private LocalDateTime fechaModificacion;

	@Column(name = "estacionModificacion")
	private String estacionModificacion;

	@Column(name = "usuarioModificacion")
	private String usuarioModificacion;
}
