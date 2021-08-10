package co.com.experis.test.controller.v1;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.experis.test.domain.request.CrearClienteRequest;
import co.com.experis.test.domain.response.CrearClienteResponse;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/clientes/v1")
public interface IClienteController {

	@ApiOperation(
            value = "Crear Cliente para Compras",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            response = CrearClienteResponse.class)
	@RequestMapping(path = "/crearCliente", method = RequestMethod.POST)
	public ResponseEntity<CrearClienteResponse> crearCliente(@RequestBody @Valid CrearClienteRequest request);
}
