package co.com.experis.test.controller.impl.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import co.com.experis.test.controller.v1.ITiendaController;
import co.com.experis.test.domain.request.ConsultarProductosRequest;
import co.com.experis.test.domain.response.ConsultarProductosResponse;
import co.com.experis.test.service.v1.ITiendaService;

@RestController
public class TiendaController implements ITiendaController {

	@Autowired
	private ITiendaService tiendaService;

	@Override
	public ResponseEntity<ConsultarProductosResponse> listarProductos() {
		return ResponseEntity.ok().body(
				ConsultarProductosResponse.builder().listaProductos(tiendaService.consultarListaProductos()).build());
	}

	@Override
	public ResponseEntity<ConsultarProductosResponse> productosPaginados(@Valid ConsultarProductosRequest request) {
		return ResponseEntity.ok(ConsultarProductosResponse.builder()
				.listaProductos(tiendaService.filtrarListaProductos(request)).build());
	}

}
