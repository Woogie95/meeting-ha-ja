package com.example.gatheringhaja.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MeetingHaJaException.class)
    public ResponseEntity<ErrorResponse> MeetingHaJaExceptionHandler(MeetingHaJaException e) {
        return ErrorResponse.errorResponse(e.getErrorCode());
    }

}
