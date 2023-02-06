package com.yash.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yash.custom.exception.EmptyInputException;
import com.yash.custom.exception.IncorrectInputException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
		return new ResponseEntity<String>("Input fields are Empty, Please add data into it", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleNoSuchElementException(
			EmptyResultDataAccessException EmptyResultDataAccessException) {
		return new ResponseEntity<String>("No value is present in DB, Please change your request ",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectInputException.class)
	public ResponseEntity<String> handleIncorrectInput(IncorrectInputException incorrectInputException) {
		return new ResponseEntity<String>("Enter Values are wrong, Please look into it", HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Please change your http method type", HttpStatus.NOT_FOUND);
	}
}