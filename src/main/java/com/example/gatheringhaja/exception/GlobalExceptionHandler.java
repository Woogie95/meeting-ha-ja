package com.example.gatheringhaja.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> duplicateEmailExceptionHandler(DuplicateEmailException e) {
        return ErrorResponse.errorResponse(e.getErrorCode());
    }

}
