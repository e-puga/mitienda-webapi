package com.mitienda.webapi.Dto;

public class AuthRespuestaDto {

	private String accessToken;
	private String tokenType = "Bearer ";

	public AuthRespuestaDto(String accessToken) {
		this.accessToken = accessToken;
	}
}
