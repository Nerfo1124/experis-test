package co.com.experis.test.service.v1;

import java.util.List;

import co.com.experis.test.domain.request.ConsultarProductosRequest;
import co.com.experis.test.model.entities.Producto;

public interface ITiendaService {

	List<Producto> consultarListaProductos();
	
	List<Producto> filtrarListaProductos(ConsultarProductosRequest request);
}
