package com.example.gatheringhaja.exception.meeting;

import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.MeetingHaJaException;

public class MeetingExceptionHandler extends MeetingHaJaException {

    public MeetingExceptionHandler(ErrorCode errorCode) {
        super(errorCode);
    }

}
