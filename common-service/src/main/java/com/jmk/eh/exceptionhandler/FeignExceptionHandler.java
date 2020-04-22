package com.jmk.eh.exceptionhandler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.eh.apierror.ApiError;

import feign.FeignException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class FeignExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger log = LoggerFactory.getLogger(FeignExceptionHandler.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@ExceptionHandler(FeignException.NotFound.class)  
	public ResponseEntity<Object> handleFeignStatusException(FeignException feignException,
			HttpServletResponse response) {
		ApiError apiError=null;
		try {
			apiError = objectMapper.readValue(feignException.content(), ApiError.class);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return buildResponseEntity(apiError);
	}
		
	
	/**
	 * Build the ResponseEntity
	 * @param apiError
	 * @return the ResponseEntity object
	 */
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		apiError=(apiError!=null)?apiError:new ApiError(HttpStatus.BAD_REQUEST, "Bad Request");
		log.error(apiError.toString());
		return new ResponseEntity<>(apiError,apiError.getStatus());
	}

}


