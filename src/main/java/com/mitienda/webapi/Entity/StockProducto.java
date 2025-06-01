package com.mitienda.webapi.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "StockProducto")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStockProducto;

	@Column(name = "idProducto", nullable = false)
	private int idProducto;

	@Column(name = "cantidadDisponible", nullable = false)
	private int cantidadDisponible;

	@Column(name = "sucursal")
	private String sucursal;

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
