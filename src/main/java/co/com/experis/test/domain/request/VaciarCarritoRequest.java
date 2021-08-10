package co.com.experis.test.domain.request;

import io.swagger.annotations.ApiModelProperty;
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
public class VaciarCarritoRequest {

	@ApiModelProperty(
            required = true,
            dataType = "Long",
            value = "ID de Cliente")
	private Long idCliente;
}
