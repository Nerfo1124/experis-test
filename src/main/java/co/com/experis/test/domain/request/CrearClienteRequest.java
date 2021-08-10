package co.com.experis.test.domain.request;

import javax.validation.constraints.NotNull;

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
public class CrearClienteRequest {

	@ApiModelProperty(
            required = true,
            dataType = "String",
            value = "Nombre del nuevo cliente")
	@NotNull(message = "Debe ingresar un nombre de usuario")
	private String nombre;
}
