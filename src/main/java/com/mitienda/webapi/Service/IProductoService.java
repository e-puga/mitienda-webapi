package com.mitienda.webapi.Service;

import java.util.List;

import com.mitienda.webapi.Dto.ProductoDto;

public interface IProductoService {

	public int GuardarProducto(ProductoDto datos);

	public List<ProductoDto> ListarProducto();
}
