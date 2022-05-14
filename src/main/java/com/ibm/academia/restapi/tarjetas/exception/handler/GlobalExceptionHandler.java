package com.ibm.academia.restapi.tarjetas.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.restapi.tarjetas.exception.BadRequestException;
import com.ibm.academia.restapi.tarjetas.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundHandler(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestHandler(BadRequestException e)
    {
    	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
