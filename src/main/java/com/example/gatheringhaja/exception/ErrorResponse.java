package com.example.gatheringhaja.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponse {

    private int status;
    private String errorName;
    private String message;

    public static ResponseEntity<ErrorResponse> errorResponse(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .errorName(errorCode.name())
                        .message(errorCode.getMessage())
                        .build());
    }

}
