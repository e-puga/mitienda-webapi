package com.mitienda.webapi.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitienda.webapi.Dto.PedidoDto;
import com.mitienda.webapi.Entity.Pedido;
import com.mitienda.webapi.Repository.PedidoRepository;
import com.mitienda.webapi.Service.IPedidoService;

@Service
public class PedidoServiceImp implements IPedidoService {

	@Autowired
	private PedidoRepository _pedidoRepository;

	@Override
	public int GuardarPedido(PedidoDto datos) {
		ModelMapper modelMapper = new ModelMapper();

		try {

			var respuesta = _pedidoRepository.findById(datos.getIdPedido()).orElse(new Pedido());
			// int idExistente = respuesta.getIdUsuario(); // Guardar el ID si ya existía

			// Configura el mapeo personalizado
			modelMapper.typeMap(PedidoDto.class, Pedido.class).addMappings(mapper -> mapper.skip(Pedido::setIdPedido));
			modelMapper.map(datos, respuesta); // Mapear del DTO a la entidad
			// respuesta.setIdUsuario(idExistente); // Restaurar el ID si ya existía

			if (respuesta == null || respuesta.getIdPedido() == 0) {
				respuesta.setFechaCreacion(LocalDateTime.now());
				respuesta.setUsuarioCreacion(datos.getUsuarioCreacion());
				respuesta.setEstacionCreacion(datos.getEstacionCreacion());
			} else {
				respuesta.setFechaModificacion(LocalDateTime.now());
				respuesta.setUsuarioModificacion(datos.getUsuarioModificacion());
				respuesta.setEstacionModificacion(datos.getEstacionModificacion());
			}

			return _pedidoRepository.save(respuesta).getIdPedido();

		} catch (Exception ex) {
			throw new RuntimeException("Error al guardar registro" + ex.getMessage());
		}
	}

	@Override
	public List<PedidoDto> ListarPedido() {
		// ModelMapper modelMapper = new ModelMapper();
		try {
			List<Pedido> respuesta = _pedidoRepository.findAll();
			return new ModelMapper().map(respuesta, new TypeToken<List<PedidoDto>>() {
			}.getType());

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener los datos" + ex.getMessage());
		}
	}
}
