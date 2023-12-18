package com.example.gatheringhaja.dto.request;

import com.example.gatheringhaja.entity.Meeting;
import com.example.gatheringhaja.entity.enumerations.MeetingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class CreateMeetingRequest {

    @NotBlank(message = "모임에 대한 제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 5, message = "내용은 최소 5자 이상 입력해주세요.")
    private String content;

    @NotBlank(message = "모임할 장소를 입력해주세요.")
    private String place;

    @NotNull(message = "모임 유형을 입력해주세요.")
    private MeetingType meetingType;

    @FutureOrPresent(message = "모집 날짜는 현재 or 미래의 날짜여야 합니다.")
    private LocalDate meetingStartDate;

    @Future(message = "마갑 날짜는 미래 날짜여야 합니다.")
    private LocalDate meetingEndDate;

    public Meeting toEntity() {
        return Meeting.builder()
                .title(this.title)
                .content(this.content)
                .place(this.place)
                .meetingType(this.meetingType)
                .likes(0)
                .views(0)
                .meetingStartDate(this.meetingStartDate)
                .meetingEndDate(this.meetingEndDate)
                .build();
    }

}
