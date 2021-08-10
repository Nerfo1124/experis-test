package co.com.experis.test.domain.response;

import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearClienteResponse {
	
	@ApiModelProperty(
            required = true,
            dataType = "Long",
            value = "ID de Cliente")
	private Long idClient;
}
