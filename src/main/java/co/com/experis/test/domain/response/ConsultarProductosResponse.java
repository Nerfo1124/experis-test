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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultarProductosResponse {

	private List<Producto> listaProductos;
}
