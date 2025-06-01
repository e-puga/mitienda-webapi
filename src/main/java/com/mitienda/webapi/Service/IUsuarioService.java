package com.mitienda.webapi.Service;

import java.util.List;

import com.mitienda.webapi.Dto.UsuarioDto;

public interface IUsuarioService {

	public int GuardarUsuario(UsuarioDto usuario);

	public List<UsuarioDto> ListarUsuario();

	/*public List<UsuarioDto> ListarUsuarioPaginacion(int numeroPagina, int medidaPagina);*/
}
