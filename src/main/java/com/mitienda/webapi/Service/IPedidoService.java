package com.mitienda.webapi.Service;

import java.util.List;

import com.mitienda.webapi.Dto.PedidoDto;

public interface IPedidoService {
	public int GuardarPedido(PedidoDto datos);

	public List<PedidoDto> ListarPedido();

}
