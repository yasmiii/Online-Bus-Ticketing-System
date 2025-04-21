package com.ticketbooking.advice;

import com.ticketbooking.execption.EntityAlreadyExistException;
import com.ticketbooking.execption.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception){

        Map<String,String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorCode> handleBusinessException(EntityNotFoundException exception){
        return new ResponseEntity<>(ErrorCode.builder()
                .errorMessage(exception.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ErrorCode> handleBusinessException(EntityAlreadyExistException exception){
        return new ResponseEntity<>(ErrorCode.builder()
                .errorMessage(exception.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
