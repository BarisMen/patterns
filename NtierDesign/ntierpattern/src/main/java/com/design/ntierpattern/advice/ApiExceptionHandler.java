package com.design.ntierpattern.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ExceptionResponse> illegalException(Exception exception, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1224",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ExceptionResponse> userNotFound (Exception exception, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1228",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> exception (Exception exception, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1232",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
