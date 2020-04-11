package com.nike.nordgym.controller;

import com.nike.nordgym.constant.Constants;
import com.nike.nordgym.error.DuplicatedResourceException;
import com.nike.nordgym.error.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private Map<String, String> errors;

    @ExceptionHandler({DuplicatedResourceException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex) {

        errors = new HashMap<>();
        errors.put(Constants.ERROR_MESSAGE, ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->
                errors.put(((FieldError) error).getField(), error.getDefaultMessage()));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleGlobalExceptionErrors(Throwable ex) {
        errors = new HashMap<>();
        errors.put(Constants.GLOBAL_EXCEPTION_ERRORS, ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errors);
    }
}
