package com.mitienda.webapi.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitienda.webapi.Dto.ProductoDto;
import com.mitienda.webapi.Entity.Producto;
import com.mitienda.webapi.Repository.ProductoRepository;
import com.mitienda.webapi.Service.IProductoService;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private ProductoRepository _productoRepository;

	@Override
	public int GuardarProducto(ProductoDto datos) {
		ModelMapper modelMapper = new ModelMapper();

		try {

			var respuesta = _productoRepository.findById(datos.getIdProducto()).orElse(new Producto());
			// int idExistente = respuesta.getIdUsuario(); // Guardar el ID si ya existía

			// Configura el mapeo personalizado
			modelMapper.typeMap(ProductoDto.class, Producto.class)
					.addMappings(mapper -> mapper.skip(Producto::setIdProducto));
			modelMapper.map(datos, respuesta); // Mapear del DTO a la entidad
			// respuesta.setIdUsuario(idExistente); // Restaurar el ID si ya existía

			if (respuesta == null || respuesta.getIdProducto() == 0) {
				respuesta.setFechaCreacion(LocalDateTime.now());
				respuesta.setUsuarioCreacion(datos.getUsuarioCreacion());
				respuesta.setEstacionCreacion(datos.getEstacionCreacion());
			} else {
				respuesta.setFechaModificacion(LocalDateTime.now());
				respuesta.setUsuarioModificacion(datos.getUsuarioModificacion());
				respuesta.setEstacionModificacion(datos.getEstacionModificacion());
			}

			return _productoRepository.save(respuesta).getIdProducto();

		} catch (Exception ex) {
			throw new RuntimeException("Error al guardar registro" + ex.getMessage());
		}
	}

	@Override
	public List<ProductoDto> ListarProducto() {
		// ModelMapper modelMapper = new ModelMapper();
		try {
			List<Producto> respuesta = _productoRepository.findAll();
			return new ModelMapper().map(respuesta, new TypeToken<List<ProductoDto>>() {
			}.getType());

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener los datos" + ex.getMessage());
		}
	}

}
