package me.bs.java.usermanagement.frontend.rest.handlers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.bs.java.aop.exception.IDNotFoundException;

@ControllerAdvice
public class RestExceptionHandlers {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	 @ExceptionHandler(value = IDNotFoundException.class)
	 public ResponseEntity<Object> idNotFoundException(IDNotFoundException exception) {
		 ResponseInfo responseInfo = new ResponseInfo(exception.getMessage(),exception.getMessage(),"failed");
		 List<String> errors = new ArrayList<String>();
		 errors.add(exception.getMessage());
		 responseInfo.setErrors(errors);
		 logger.error("RestExceptionHandlers RESPONSE {}", HttpStatus.NOT_FOUND);

		 return new ResponseEntity<>(responseInfo, HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler(value = Exception.class)
	 public ResponseEntity<Object> genericException(Exception exception) {
		 ResponseInfo responseInfo = new ResponseInfo(exception.getMessage(),exception.getMessage(),"failed");
		 List<String> errors = new ArrayList<String>();
		 errors.add(exception.getMessage());
		 responseInfo.setErrors(errors);
		 logger.error("RestExceptionHandlers RESPONSE {}", HttpStatus.INTERNAL_SERVER_ERROR);

		 return new ResponseEntity<>(responseInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}
