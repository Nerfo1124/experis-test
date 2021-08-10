package co.com.experis.test.controller.impl.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import co.com.experis.test.controller.v1.IClienteController;
import co.com.experis.test.domain.request.CrearClienteRequest;
import co.com.experis.test.domain.response.CrearClienteResponse;
import co.com.experis.test.service.v1.IClienteService;

@RestController
public class ClienteController implements IClienteController {

	@Autowired
	private IClienteService clientService;

	@Override
	public ResponseEntity<CrearClienteResponse> crearCliente(@Valid CrearClienteRequest request) {
		return ResponseEntity.ok(CrearClienteResponse.builder().idClient(clientService.crearCliente(request)).build());
	}

}
