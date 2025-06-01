package com.mitienda.webapi.Dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
	private int idCliente;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String celular;
	private String correo;
	private String direccion;
	private String estadoCivil;
	private String estado;
	private LocalDateTime fechaCreacion;
	private String usuarioCreacion;
	private String estacionCreacion;
	private LocalDateTime fechaModificacion;
	private String usuarioModificacion;
	private String estacionModificacion;
}
