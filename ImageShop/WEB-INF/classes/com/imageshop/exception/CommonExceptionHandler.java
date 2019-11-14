package com.imageshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class CommonExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler(NotEnoughCoinException.class)
	public String handleNotEnoughCoinException(NotEnoughCoinException ex,WebRequest request) {
		logger.info("handleNotEnoughCoinException");
		
		return "redirect:/coin/notEnoughCoin";
		
	}
	
	
	@ExceptionHandler(NotMyItemException.class)
	public String handleNotMyItemException(NotMyItemException ex,WebRequest request) {
		logger.info("handleNotMyItemException");
		
		return "redirect:/useritem/notMyItem";
	}

	
	@ExceptionHandler(AccessDeniedException.class)
	public void handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		if(isAjax(request)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
		}else {
			throw ex;
		}
	}

	public static boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}


	@ExceptionHandler(Exception.class)
	public String handle(Exception ex) {
		logger.info("handle ex"+ex.toString());
		
		return "error/errorCommon";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(Exception ex) {
		logger.info(ex.toString());
		
		return "error/custom404";
	}
	
}
