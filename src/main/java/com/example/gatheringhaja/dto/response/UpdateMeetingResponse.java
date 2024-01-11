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
public class UpdateMeetingResponse {

    private Long id;
    private String title;
    private String content;
    private String place;
    private MeetingType meetingType;
    private long likes;
    private long views;
    private LocalDate created;
    private LocalDate updated;
    private LocalDate meetingStartDate;
    private LocalDate meetingEndDate;

    public static UpdateMeetingResponse from(Meeting meeting) {
        return UpdateMeetingResponse.builder()
                .id(meeting.getId())
                .title(meeting.getTitle())
                .content(meeting.getContent())
                .place(meeting.getPlace())
                .meetingType(meeting.getMeetingType())
                .likes(meeting.getLikes())
                .views(meeting.getViews())
                .created(meeting.getCreated())
                .updated(meeting.getUpdated())
                .meetingStartDate(meeting.getMeetingStartDate())
                .meetingEndDate(meeting.getMeetingEndDate())
                .build();
    }

}
