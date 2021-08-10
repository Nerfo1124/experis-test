package co.com.experis.test.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.experis.test.domain.exception.dto.ErrorResponse;
import co.com.experis.test.enumerable.ErrorMessageEnum;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class ServiceExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> bodyRequestEmpty(final HttpMessageNotReadableException ex) {
		String errorCode = ErrorMessageEnum.EMPTY_REQUEST.getCode();
		String errorMessage = ErrorMessageEnum.EMPTY_REQUEST.getMessage();
		LOGGER.info(getMessage(HttpStatus.BAD_REQUEST.value(), errorCode, errorMessage));
		return ResponseEntity.badRequest().body(buildResponse(errorCode, errorMessage));
	}
	
	@ResponseBody
	@ExceptionHandler(ClassCastException.class)
	public ResponseEntity<ErrorResponse> internalServiceError(final ClassCastException ex) {
		String errorCode = ErrorMessageEnum.GENERAL_ERROR.getCode();
		String errorMessage = ErrorMessageEnum.GENERAL_ERROR.getMessage();
		LOGGER.info(getMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorCode, errorMessage));
		return ResponseEntity.badRequest().body(buildResponse(errorCode, errorMessage));
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> GeneralServiceError(final Exception ex) {
		String errorCode = ErrorMessageEnum.GENERAL_ERROR.getCode();
		String errorMessage = ErrorMessageEnum.GENERAL_ERROR.getMessage();
		LOGGER.info(getMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorCode, errorMessage));
		return ResponseEntity.badRequest().body(buildResponse(errorCode, errorMessage));
	}

	private String getMessage(int httpStatus, String error, String message) {
		return String.format("http status:[%d] - Code: [%s] Message: %s", httpStatus, error, message);
	}

	private ErrorResponse buildResponse(String errorCode, String errorMessage) {
		return ErrorResponse.builder().status("ERROR").errorCode(errorCode).errorMessage(errorMessage).build();
	}
}
