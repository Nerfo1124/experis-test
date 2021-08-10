package co.com.experis.test.service.v1;

import co.com.experis.test.domain.request.AgregarCarritoRequest;
import co.com.experis.test.domain.request.ConsultarCarritoRequest;
import co.com.experis.test.domain.request.FinalizarCompraRequest;
import co.com.experis.test.domain.request.VaciarCarritoRequest;
import co.com.experis.test.domain.response.AgregarCarritoResponse;
import co.com.experis.test.domain.response.ConsultarCarritoResponse;
import co.com.experis.test.domain.response.FinalizarCompraResponse;
import co.com.experis.test.domain.response.VaciarCarritoResponse;

public interface ICarritoService {

	public ConsultarCarritoResponse consultarCarrito(ConsultarCarritoRequest request);
	
	public AgregarCarritoResponse agregarProductoACarrito(AgregarCarritoRequest request);
	
	public VaciarCarritoResponse vaciarCarrito(VaciarCarritoRequest request);
	
	public FinalizarCompraResponse finalizarCompra(FinalizarCompraRequest request);
}
