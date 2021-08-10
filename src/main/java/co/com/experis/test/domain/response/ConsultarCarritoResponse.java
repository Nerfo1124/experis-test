package co.com.experis.test.domain.response;

import java.util.List;

import co.com.experis.test.model.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultarCarritoResponse {

	private Long idClient;
	private List<Producto> listaProductos;
}
