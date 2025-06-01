package com.mitienda.webapi.Dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
	private int idPedido;
	private int idCliente;
	private LocalDateTime fechaPedido;
	private int cantidad;
	private String estado;
	private Double total;
	private Double descuento;
	private Double totalFinal;
	private LocalDateTime fechaCreacion;
	private String usuarioCreacion;
	private String estacionCreacion;
	private LocalDateTime fechaModificacion;
	private String estacionModificacion;
	private String usuarioModificacion;
}
