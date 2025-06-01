package com.mitienda.webapi.Service;

import java.util.List;

import com.mitienda.webapi.Dto.ClienteDto;

public interface IClienteService {
	
	public int GuardarCliente(ClienteDto datos);

	public List<ClienteDto> ListarCliente();

}
