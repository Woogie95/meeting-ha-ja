package com.example.gatheringhaja.exception.member;

import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.MeetingHaJaException;

public class MemberExceptionHandler extends MeetingHaJaException {

    public MemberExceptionHandler(ErrorCode errorCode) {
        super(errorCode);
    }

}
