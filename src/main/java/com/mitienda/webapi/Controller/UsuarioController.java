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

import com.mitienda.webapi.Dto.UsuarioDto;
import com.mitienda.webapi.Service.IUsuarioService;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

	@Autowired
	private IUsuarioService _usuarioService;

	@PostMapping("GuardarUsuario")
	public ResponseEntity<Integer> GuardarUsuario(@RequestBody UsuarioDto usuario) {
		return new ResponseEntity<>(_usuarioService.GuardarUsuario(usuario), HttpStatus.CREATED);
	}

	@GetMapping("ListarUsuario")
	public ResponseEntity<List<UsuarioDto>> ListarUsuario() {
		return new ResponseEntity<>(_usuarioService.ListarUsuario(), HttpStatus.OK);
	}

	// Lista con paginación
	/*
	 * @GetMapping("ListarUsuarioPaginacion") public
	 * ResponseEntity<List<UsuarioDto>> ListarUsuarioPaginacion(
	 * 
	 * @RequestParam(value = "pageNo", defaultValue = "0", required = false) int
	 * numeroPagina,
	 * 
	 * @RequestParam(value = "pageSize", defaultValue = "10", required = false) int
	 * medidaPagina) { return new
	 * ResponseEntity<>(_usuarioService.ListarUsuarioPaginacion(numeroPagina,
	 * medidaPagina), HttpStatus.OK); }
	 */

}
