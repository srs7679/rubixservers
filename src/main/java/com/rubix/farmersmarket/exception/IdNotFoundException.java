package com.rubix.farmersmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 
 * @class ResourceNotFoundException 
 * Returns the message of user details when there is a response
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class  IdNotFoundException  extends Exception{

    private static final long serialVersionUID = 1L;

    public IdNotFoundException(String message){
        super(message);
    }
}