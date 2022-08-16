package com.dale.projetoestudo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends RuntimeException{
    
    public ResourceNotFoundExecption(String message){
        super(message);
    }
}
