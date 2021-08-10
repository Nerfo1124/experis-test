package co.com.experis.test.controller.v1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.experis.test.domain.request.AgregarCarritoRequest;
import co.com.experis.test.domain.request.ConsultarCarritoRequest;
import co.com.experis.test.domain.request.FinalizarCompraRequest;
import co.com.experis.test.domain.request.VaciarCarritoRequest;
import co.com.experis.test.domain.response.AgregarCarritoResponse;
import co.com.experis.test.domain.response.ConsultarCarritoResponse;
import co.com.experis.test.domain.response.FinalizarCompraResponse;
import co.com.experis.test.domain.response.VaciarCarritoResponse;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/carrito/v1")
public interface ICarritoController {
	
	@ApiOperation(
            value = "Consultar Carrito de Compras",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = ConsultarCarritoResponse.class)
	@RequestMapping(path = "/consultarCarrito", method = RequestMethod.POST)
	public ResponseEntity<ConsultarCarritoResponse> consultarCarrito(ConsultarCarritoRequest request);

	@ApiOperation(
            value = "Agregar Producto a Carrito",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = AgregarCarritoResponse.class)
	@RequestMapping(path = "/agregarProductoACarrito", method = RequestMethod.POST)
	public ResponseEntity<AgregarCarritoResponse> agregarProductoACarrito(AgregarCarritoRequest request);
	
	@ApiOperation(
            value = "Vaciar Carrito de Compras",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = VaciarCarritoResponse.class)
	@RequestMapping(path = "/vaciarCarrito", method = RequestMethod.POST)
	public ResponseEntity<VaciarCarritoResponse> vaciarCarrito(VaciarCarritoRequest request);
	
	@ApiOperation(
            value = "Finalizar Compra",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = FinalizarCompraResponse.class)
	@RequestMapping(path = "/finalizarCompra", method = RequestMethod.POST)
	public ResponseEntity<FinalizarCompraResponse> finalizarCompra(FinalizarCompraRequest request);
}
