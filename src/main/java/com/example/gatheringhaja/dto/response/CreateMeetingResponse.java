package com.example.gatheringhaja.dto.response;

import com.example.gatheringhaja.entity.Meeting;
import com.example.gatheringhaja.entity.enumerations.MeetingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMeetingResponse {

    private Long id;
    private String title;
    private String content;
    private String place;
    private MeetingType meetingType;
    private long likes;
    private long views;
    private LocalDate meetingStartDate;
    private LocalDate meetingEndDate;
    private LocalDate created;
    private LocalDate updated;
    private String nickname;
    private Long memberId;

    public static CreateMeetingResponse from(Meeting meeting) {
        return CreateMeetingResponse.builder()
                .id(meeting.getId())
                .title(meeting.getTitle())
                .content(meeting.getContent())
                .place(meeting.getPlace())
                .meetingType(meeting.getMeetingType())
                .likes(meeting.getLikes())
                .views(meeting.getViews())
                .meetingStartDate(meeting.getMeetingStartDate())
                .meetingEndDate(meeting.getMeetingEndDate())
                .created(meeting.getCreated())
                .updated(meeting.getUpdated())
                .nickname(meeting.getMember().getNickname())
                .memberId(meeting.getMember().getId())
                .build();
    }

}