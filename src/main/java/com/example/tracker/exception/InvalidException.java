package com.example.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidException extends RuntimeException{
    public InvalidException(String Message){
        super(Message);
    }
}
