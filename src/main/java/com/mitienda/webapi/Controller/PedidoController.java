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

import com.mitienda.webapi.Dto.PedidoDto;
import com.mitienda.webapi.Service.IPedidoService;

@RestController
@RequestMapping("/api/pedido/")
public class PedidoController {

	@Autowired
	private IPedidoService _pedidoService;

	@PostMapping("GuardarPedido")
	public ResponseEntity<Integer> GuardarPedido(@RequestBody PedidoDto datos) {
		return new ResponseEntity<>(_pedidoService.GuardarPedido(datos), HttpStatus.CREATED);
	}

	@GetMapping("ListarPedido")
	public ResponseEntity<List<PedidoDto>> ListarPedido() {
		return new ResponseEntity<>(_pedidoService.ListarPedido(), HttpStatus.OK);
	}

}
