package co.com.experis.test.domain.request;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;
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
public class AgregarCarritoRequest {
	
	@ApiModelProperty(
            required = true,
            dataType = "Long",
            value = "ID de Cliente")
	private Long idCliente;
	@ApiModelProperty(
            required = true,
            dataType = "Long",
            value = "ID de Producto a Comprar")
	private Long idProducto;
	
	@ApiModelProperty(
            required = true,
            dataType = "Long",
            value = "Productos a comprar")
	@Min(value = 1, message = "La cantidad del producto a comprar debe ser minimo 1")
	private Integer cantidad;
}
