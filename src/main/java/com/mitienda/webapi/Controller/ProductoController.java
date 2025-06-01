package com.mitienda.webapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitienda.webapi.Dto.ProductoDto;
import com.mitienda.webapi.Service.IProductoService;

@RestController
@RequestMapping("/api/producto/")
public class ProductoController {

	@Autowired
	private IProductoService _productoService;

	@PostMapping("GuardarPorducto")
	public ResponseEntity<Integer> GuardarCliente(@RequestBody ProductoDto datos) {
		return new ResponseEntity<>(_productoService.GuardarProducto(datos), HttpStatus.CREATED);
	}

	@GetMapping("ListarProducto")
	public ResponseEntity<List<ProductoDto>> ListarCliente() {
		return new ResponseEntity<>(_productoService.ListarProducto(), HttpStatus.OK);
	}

}
