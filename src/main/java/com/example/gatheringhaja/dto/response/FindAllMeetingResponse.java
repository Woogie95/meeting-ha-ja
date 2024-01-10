package com.example.gatheringhaja.dto.response;

import com.example.gatheringhaja.entity.Comment;
import com.example.gatheringhaja.entity.Meeting;
import com.example.gatheringhaja.entity.enumerations.MeetingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllMeetingResponse {

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
    private List<Comment> comments;
    private String nickname;
    private Long memberId;

    public static FindAllMeetingResponse from(Meeting meeting) {
        return FindAllMeetingResponse.builder()
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
                .comments(meeting.getComments())
                .nickname(meeting.getMember().getNickname())
                .memberId(meeting.getMember().getId())
                .build();
    }

}
