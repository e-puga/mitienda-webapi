package com.mitienda.webapi.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitienda.webapi.Dto.ClienteDto;
import com.mitienda.webapi.Entity.Cliente;
import com.mitienda.webapi.Repository.ClienteRepository;
import com.mitienda.webapi.Service.IClienteService;

@Service
public class ClienteServiceImp implements IClienteService {

	@Autowired
	private ClienteRepository _clienteRepository;

	@Override
	public int GuardarCliente(ClienteDto datos) {
		ModelMapper modelMapper = new ModelMapper();

		try {

			var respuesta = _clienteRepository.findByIdentificacion(datos.getIdentificacion()).orElse(new Cliente());
			// int idExistente = respuesta.getIdUsuario(); // Guardar el ID si ya existía

			// Configura el mapeo personalizado
			modelMapper.typeMap(ClienteDto.class, Cliente.class)
					.addMappings(mapper -> mapper.skip(Cliente::setIdCliente));
			modelMapper.map(datos, respuesta); // Mapear del DTO a la entidad
			// respuesta.setIdUsuario(idExistente); // Restaurar el ID si ya existía

			if (respuesta == null || respuesta.getIdCliente() == 0) {
				respuesta.setFechaCreacion(LocalDateTime.now());
				respuesta.setUsuarioCreacion(datos.getUsuarioCreacion());
				respuesta.setEstacionCreacion(datos.getEstacionCreacion());
			} else {
				respuesta.setFechaModificacion(LocalDateTime.now());
				respuesta.setUsuarioModificacion(datos.getUsuarioModificacion());
				respuesta.setEstacionModificacion(datos.getEstacionModificacion());
			}

			return _clienteRepository.save(respuesta).getIdCliente();

		} catch (Exception ex) {
			throw new RuntimeException("Error al guardar registro" + ex.getMessage());
		}
	}

	@Override
	public List<ClienteDto> ListarCliente() {
		// ModelMapper modelMapper = new ModelMapper();
		try {
			List<Cliente> respuesta = _clienteRepository.findAll();
			return new ModelMapper().map(respuesta, new TypeToken<List<ClienteDto>>() {
			}.getType());

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener los datos" + ex.getMessage());
		}
	}
}
