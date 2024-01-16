package com.example.gatheringhaja.dto;

import com.example.gatheringhaja.entity.Meeting;
import com.example.gatheringhaja.entity.enumerations.MeetingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingPayload {

    private Long id;
    private String title;
    private String content;
    private String place;
    private MeetingType meetingType;
    private long likes;
    private long views;
    private LocalDate meetingStartDate;
    private LocalDate meetingEndDate;
    private List<CommentPayload> commentPayloads;

    public Meeting toEntity() {
        return Meeting.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .place(this.place)
                .meetingType(this.meetingType)
                .likes(this.likes)
                .views(this.views)
                .meetingStartDate(this.meetingStartDate)
                .meetingEndDate(this.meetingEndDate)
                .build();
    }

    public static MeetingPayload from(Meeting meeting) {
        return MeetingPayload.builder()
                .id(meeting.getId())
                .title(meeting.getTitle())
                .content(meeting.getContent())
                .place(meeting.getPlace())
                .meetingType(meeting.getMeetingType())
                .likes(meeting.getLikes())
                .views(meeting.getViews())
                .meetingStartDate(meeting.getMeetingStartDate())
                .meetingEndDate(meeting.getMeetingEndDate())
                .commentPayloads(meeting.getComments().stream()
                        .map(CommentPayload::from)
                        .collect(Collectors.toList()))
                .build();
    }

}
