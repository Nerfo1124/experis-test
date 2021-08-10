package co.com.experis.test.controller.v1;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.experis.test.domain.request.ConsultarProductosRequest;
import co.com.experis.test.domain.response.ConsultarProductosResponse;
import co.com.experis.test.domain.response.CrearClienteResponse;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/productos/v1")
public interface ITiendaController {

	@ApiOperation(
            value = "Consultar Catalogo de Productos",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = CrearClienteResponse.class)
	@RequestMapping(path = "/listarProductos", method = RequestMethod.POST)
	public ResponseEntity<ConsultarProductosResponse> listarProductos();
	
	@ApiOperation(
            value = "Consultar Producto Paginados",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = CrearClienteResponse.class)
	@RequestMapping(path = "/productosPaginados", method = RequestMethod.POST)
	public ResponseEntity<ConsultarProductosResponse> productosPaginados(@RequestBody @Valid ConsultarProductosRequest request);
}
