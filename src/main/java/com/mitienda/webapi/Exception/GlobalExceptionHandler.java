package com.mitienda.webapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.mitienda.webapi.Dto.ApiResponse;

@RestControllerAdvice // Detecta todos los errores
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // Obtiene los errores en tiempo de ejecucion y los controlamos
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest) {
		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
