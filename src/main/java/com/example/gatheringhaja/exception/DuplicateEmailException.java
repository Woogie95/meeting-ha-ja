package com.example.gatheringhaja.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DuplicateEmailException extends RuntimeException {

    private ErrorCode errorCode;

}
