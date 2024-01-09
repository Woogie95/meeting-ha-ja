package com.example.gatheringhaja.exception;

import com.example.gatheringhaja.exception.meeting.MeetingExceptionHandler;
import com.example.gatheringhaja.exception.member.MemberExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberExceptionHandler.class)
    public ResponseEntity<ErrorResponse> handleMemberException(MemberExceptionHandler e) {
        return ErrorResponse.errorResponse(e.getErrorCode());
    }

    @ExceptionHandler(MeetingExceptionHandler.class)
    public ResponseEntity<ErrorResponse> handleMeetingException(MeetingExceptionHandler e) {
        return ErrorResponse.errorResponse(e.getErrorCode());
    }

}
