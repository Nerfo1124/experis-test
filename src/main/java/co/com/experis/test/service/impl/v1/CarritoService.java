package co.com.experis.test.service.impl.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.experis.test.domain.request.AgregarCarritoRequest;
import co.com.experis.test.domain.request.ConsultarCarritoRequest;
import co.com.experis.test.domain.request.FinalizarCompraRequest;
import co.com.experis.test.domain.request.VaciarCarritoRequest;
import co.com.experis.test.domain.response.AgregarCarritoResponse;
import co.com.experis.test.domain.response.ConsultarCarritoResponse;
import co.com.experis.test.domain.response.FinalizarCompraResponse;
import co.com.experis.test.domain.response.VaciarCarritoResponse;
import co.com.experis.test.model.entities.Carrito;
import co.com.experis.test.model.entities.Producto;
import co.com.experis.test.model.repositories.CarritoRepository;
import co.com.experis.test.model.repositories.ProductoRespository;
import co.com.experis.test.service.v1.ICarritoService;

@Service
public class CarritoService implements ICarritoService {

	@Autowired
	private CarritoRepository carritoDB;
	
	@Autowired
	private ProductoRespository productoDB;
	
	@Override
	public ConsultarCarritoResponse consultarCarrito(ConsultarCarritoRequest request) {
		ConsultarCarritoResponse response = ConsultarCarritoResponse.builder().idClient(request.getIdClient()).build();
		List<Producto> listaCarrito = (List<Producto>) productoDB.findAllById(carritoDB.findAllByIdClient(request.getIdClient()));
		response.setListaProductos(listaCarrito);
		return response;
	}

	@Override
	public AgregarCarritoResponse agregarProductoACarrito(AgregarCarritoRequest request) {
		carritoDB.saveProducto(request.getIdCliente(), request.getIdProducto(), request.getCantidad());
		return AgregarCarritoResponse.builder().status("OK").message("Producto agregado al carrito").build();
	}

	@Override
	public VaciarCarritoResponse vaciarCarrito(VaciarCarritoRequest request) {
		Carrito deleteCarrito = new Carrito(null, request.getIdCliente(), null, null);
		carritoDB.delete(deleteCarrito);
		return VaciarCarritoResponse.builder().status("OK").message("Carrito de compras vaciado correctamente").build();
	}

	@Override
	public FinalizarCompraResponse finalizarCompra(FinalizarCompraRequest request) {
		return null;
	}
}
