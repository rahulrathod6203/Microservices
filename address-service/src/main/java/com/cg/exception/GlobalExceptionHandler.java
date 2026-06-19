package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AddressNotFoundException.class)
    public ExceptionResponse studentNotFoundExceptionHandler(WebRequest request, AddressNotFoundException exception){

        String trimmedPath = request.getDescription(false).replace("uri=","");
        return ExceptionResponse.builder()
                .timeStamp(Instant.now())
                .errorMessage(exception.getMessage())
                .status(String.valueOf(HttpStatus.NOT_FOUND))
                .path(trimmedPath)
                .build();
    }
}
