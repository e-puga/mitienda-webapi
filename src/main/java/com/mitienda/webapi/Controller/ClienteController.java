package com.mitienda.webapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitienda.webapi.Dto.ClienteDto;
import com.mitienda.webapi.Dto.UsuarioDto;
import com.mitienda.webapi.Service.IClienteService;
import com.mitienda.webapi.Service.IUsuarioService;

@RestController
@RequestMapping("/api/cliente/")
public class ClienteController {

	@Autowired
	private IClienteService _clienteService;

	@PostMapping("GuardarCliente")
	public ResponseEntity<Integer> GuardarCliente(@RequestBody ClienteDto datos) {
		return new ResponseEntity<>(_clienteService.GuardarCliente(datos), HttpStatus.CREATED);
	}

	@GetMapping("ListarCliente")
	public ResponseEntity<List<ClienteDto>> ListarCliente() {
		return new ResponseEntity<>(_clienteService.ListarCliente(), HttpStatus.OK);
	}

}
