package co.com.experis.test.enumerable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {

	GENERAL_ERROR("500", "Error en el sistema intente mas tarde"),
	EMPTY_REQUEST("400", "Objeto request no especificado");
	
	private final String code;
	private final String message;
}
