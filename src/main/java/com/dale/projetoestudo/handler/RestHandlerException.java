package com.dale.projetoestudo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dale.projetoestudo.model.error.ErrorMessage;
import com.dale.projetoestudo.model.exception.ResourceNotFoundExecption;

@ControllerAdvice
public class RestHandlerException {
    
    @ExceptionHandler(ResourceNotFoundExecption.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundExecption ex){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
