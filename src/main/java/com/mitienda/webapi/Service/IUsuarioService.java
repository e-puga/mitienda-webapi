package com.mitienda.webapi.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.mitienda.webapi.Dto.AuthRespuestaDto;
import com.mitienda.webapi.Dto.LoginDto;
import com.mitienda.webapi.Dto.UsuarioDto;

public interface IUsuarioService {

	public int GuardarUsuario(UsuarioDto usuario);

	public List<UsuarioDto> ListarUsuario();

	public AuthRespuestaDto login(@RequestBody LoginDto login);

	/*
	 * public List<UsuarioDto> ListarUsuarioPaginacion(int numeroPagina, int
	 * medidaPagina);
	 */
}
