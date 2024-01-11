package com.example.gatheringhaja.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MessageResponse {

    private String message;

    public static final String MEMBER_DELETED = "회원이 삭제되었습니다.";
    public static final String MEETING_DELETED = "모임이 삭제되었습니다.";

    public static MessageResponse from(String message) {
        return MessageResponse.builder()
                .message(message)
                .build();
    }

}
