package com.example.gatheringhaja.dto.request;

import com.example.gatheringhaja.entity.enumerations.MeetingType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class UpdateMeetingRequest {

    @Size(min = 2, message = "제목은 최소 2자 이상이어야 합니다.")
    private String title;

    @Size(min = 5, message = "내용은 최소 5자 이상 입력해주세요.")
    private String content;

    private String place;

    private MeetingType meetingType;

    @FutureOrPresent(message = "모집 날짜는 현재 or 미래의 날짜여야 합니다.")
    private LocalDate meetingStartDate;

    @Future(message = "마감 날짜는 미래 날짜여야 합니다.")
    private LocalDate meetingEndDate;

    @NotNull(message = "사용자 ID는 null 일 수 없습니다.")
    private Long memberId;

}
