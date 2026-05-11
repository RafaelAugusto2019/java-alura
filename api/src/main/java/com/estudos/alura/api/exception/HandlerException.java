package com.estudos.alura.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity exceptionNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity exceptionMethodArgumentNotValid(MethodArgumentNotValidException exception){
        var listErrors = exception.getFieldErrors();
        
        return ResponseEntity.badRequest().body(
                listErrors.stream().map(ErrorResponse::new).toList());
    }


    private record ErrorResponse(String error, String detail){

        public ErrorResponse(FieldError filFieldError){
            this(filFieldError.getField(), filFieldError.getDefaultMessage());
        }
    }

}


