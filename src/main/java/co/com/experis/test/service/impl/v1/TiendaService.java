package co.com.experis.test.service.impl.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.experis.test.domain.request.ConsultarProductosRequest;
import co.com.experis.test.model.entities.Producto;
import co.com.experis.test.model.repositories.ProductoRespository;
import co.com.experis.test.service.v1.ITiendaService;

@Service
public class TiendaService implements ITiendaService {

	@Autowired
	private ProductoRespository productosDB;

	@Override
	public List<Producto> consultarListaProductos() {
		return (List<Producto>) productosDB.findAll();
	}

	@Override
	public List<Producto> filtrarListaProductos(ConsultarProductosRequest request) {
		Pageable pagination = null;
		if (request.getPageSize() != null && request.getPageView() != null) {
			pagination = PageRequest.of(request.getPageView().intValue(), request.getPageSize().intValue());
		} else {
			pagination = PageRequest.of(0, 3);
		}

		if (request.getNombreFilter() != null) {
			return productosDB.findByNombre(request.getNombreFilter(), pagination);
		} else {
			return productosDB.findAll(pagination).toList();
		}
	}

}
