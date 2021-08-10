package co.com.experis.test.controller.impl.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import co.com.experis.test.controller.v1.ICarritoController;
import co.com.experis.test.domain.request.AgregarCarritoRequest;
import co.com.experis.test.domain.request.ConsultarCarritoRequest;
import co.com.experis.test.domain.request.FinalizarCompraRequest;
import co.com.experis.test.domain.request.VaciarCarritoRequest;
import co.com.experis.test.domain.response.AgregarCarritoResponse;
import co.com.experis.test.domain.response.ConsultarCarritoResponse;
import co.com.experis.test.domain.response.FinalizarCompraResponse;
import co.com.experis.test.domain.response.VaciarCarritoResponse;
import co.com.experis.test.service.v1.ICarritoService;

@RestController
public class CarritoController implements ICarritoController {
	
	@Autowired
	private ICarritoService carritoService;

	@Override
	public ResponseEntity<ConsultarCarritoResponse> consultarCarrito(ConsultarCarritoRequest request) {
		return ResponseEntity.ok(carritoService.consultarCarrito(request));
	}

	@Override
	public ResponseEntity<AgregarCarritoResponse> agregarProductoACarrito(AgregarCarritoRequest request) {
		return ResponseEntity.ok(carritoService.agregarProductoACarrito(request));
	}

	@Override
	public ResponseEntity<VaciarCarritoResponse> vaciarCarrito(VaciarCarritoRequest request) {
		return ResponseEntity.ok(carritoService.vaciarCarrito(request));
	}

	@Override
	public ResponseEntity<FinalizarCompraResponse> finalizarCompra(FinalizarCompraRequest request) {
		return ResponseEntity.ok(carritoService.finalizarCompra(request));
	}
}
