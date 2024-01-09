package com.example.gatheringhaja.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "존재하는 회원이 없습니다."),
    NOT_FOUND_EMAIL(HttpStatus.NOT_FOUND, "해당하는 이메일을 찾을 수 없습니다."),
    NOT_FOUND_LOAD_FILE(HttpStatus.NOT_FOUND, "파일을 찾을 수 없습니다."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "입력한 비밀번호가 일치 하지 않습니다."),
    ALREADY_DELETED_MEMBER(HttpStatus.BAD_REQUEST, "이미 삭제된 회원입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}