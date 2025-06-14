package com.mitienda.webapi.Dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {

	private Date tiempo = new Date(0);
	private String mensaje;
	private String url;

	public ApiResponse(String mensaje, String url) {
		this.mensaje = mensaje;
		this.url = url.replace("uri=", "");
	}

}
