package co.com.experis.test.domain.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class ConsultarProductosRequest {

	@ApiModelProperty(
            required = true,
            dataType = "String",
            value = "Filtrar por nombre de producto")
	private String nombreFilter;
	
	@ApiModelProperty(
            required = true,
            dataType = "String",
            value = "Filtrar por marca de producto")
	private String marcaFilter;
	
	@ApiModelProperty(
            required = true,
            dataType = "String",
            value = "Filtrar por rango de precios de producto [rangoMin-rangoMax")
	private String preciosFilter;

	@NotNull(message = "Valor del campo no puede ser nulo")
	@Min(value = 0, message = "Valor de campo invalido")
	@Max(value = 5, message = "Valor de campo invalido")
	private Integer pageSize;

	@NotNull(message = "Valor del campo no puede ser nulo")
	@Min(value = 0, message = "Valor de campo invalido")
	@Max(value = 5, message = "Valor de campo invalido")
	private Integer pageView;
	private String sortFilter;

	public Long[] getRangoPrecios() {
		String[] split = this.preciosFilter.split("-");
		Long[] rangoPrecios = {};
		for (int i = 0; i < 2; i++) {
			try {
				rangoPrecios[i] = Long.parseLong(split[i]);
			} catch (NumberFormatException e) {
				throw new NumberFormatException();
			}
		}
		return rangoPrecios;
	}
}
