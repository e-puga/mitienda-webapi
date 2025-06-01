package com.mitienda.webapi.ServiceImp;


import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mitienda.webapi.Dto.UsuarioDto;
import com.mitienda.webapi.Entity.Usuario;
import com.mitienda.webapi.Repository.UsuarioRepository;
import com.mitienda.webapi.Service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	UsuarioRepository _usuarioRepository;

	@Override
	public int GuardarUsuario(UsuarioDto usuario) {
		ModelMapper modelMapper = new ModelMapper();
		// int idUsuario = 0;

		try {

			var respuesta = _usuarioRepository.findByUsername(usuario.getUsername()).orElse(new Usuario());
			// int idExistente = respuesta.getIdUsuario(); // Guardar el ID si ya existía

			// Configura el mapeo personalizado
			modelMapper.typeMap(UsuarioDto.class, Usuario.class)
					.addMappings(mapper -> mapper.skip(Usuario::setIdUsuario));
			modelMapper.map(usuario, respuesta); // Mapear del DTO a la entidad
			// respuesta.setIdUsuario(idExistente); // Restaurar el ID si ya existía

			if (respuesta == null || respuesta.getIdUsuario() == 0) {
				respuesta.setFechaCreacion(LocalDateTime.now());
				respuesta.setUsuarioCreacion(usuario.getUsuarioCreacion());
				respuesta.setEstacionCreacion(usuario.getEstacionCreacion());
			} else {
				respuesta.setFechaModificacion(LocalDateTime.now());
				respuesta.setUsuarioModificacion(usuario.getUsuarioModificacion());
				respuesta.setEstacionModificacion(usuario.getEstacionModificacion());
			}

			return _usuarioRepository.save(respuesta).getIdUsuario();

		} catch (Exception ex) {
			throw new RuntimeException("Error al guardar usuario" + ex.getMessage());
		}
		// return idUsuario;
	}

	@Override
	public List<UsuarioDto> ListarUsuario() {
		// ModelMapper modelMapper = new ModelMapper();
		try {
			List<Usuario> respuesta = _usuarioRepository.findAll();
			return new ModelMapper().map(respuesta, new TypeToken<List<UsuarioDto>>() {
			}.getType());

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener los usuarios" + ex.getMessage());
		}
	}

	/*@Override
	public List<UsuarioDto> ListarUsuarioPaginacion(int numeroPagina, int medidaPagina) {
		// ModelMapper modelMapper = new ModelMapper();
		try {
			Pageable pageable = PageRequest.of(numeroPagina, medidaPagina);
			Page<Usuario> usuario = _usuarioRepository.findAll(pageable);
			
			List<Usuario> respuesta = usuario.getContent();
			return new ModelMapper().map(respuesta, new TypeToken<List<UsuarioDto>>() {
			}.getType());

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener los usuarios" + ex.getMessage());
		}
	}*/

}
