package com.example.gatheringhaja.entity;

import com.example.gatheringhaja.dto.request.UpdateCommentRequest;
import com.example.gatheringhaja.dto.request.UpdateMeetingRequest;
import com.example.gatheringhaja.entity.enumerations.MeetingType;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.meeting.MeetingExceptionHandler;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meeting extends BaseTimeEntity {

    private static final int LATEST_INDEX_VALUE = 1;
    private static final int INCREMENT_VIEW_COUNT = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String place;

    @Enumerated(EnumType.STRING)
    private MeetingType meetingType;

    private long likes;

    private long views;

    private LocalDate meetingStartDate;

    private LocalDate meetingEndDate;

    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private Set<Applicant> applicants = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    public void updateMeetingInfo(UpdateMeetingRequest updateMeetingRequest) {
        if (updateMeetingRequest.getTitle() != null) {
            this.title = updateMeetingRequest.getTitle();
        }
        if (updateMeetingRequest.getContent() != null) {
            this.content = updateMeetingRequest.getContent();
        }
        if (updateMeetingRequest.getPlace() != null) {
            this.place = updateMeetingRequest.getPlace();
        }
        if (updateMeetingRequest.getMeetingType() != null) {
            this.meetingType = updateMeetingRequest.getMeetingType();
        }
        if (updateMeetingRequest.getMeetingStartDate() != null) {
            this.meetingStartDate = updateMeetingRequest.getMeetingStartDate();
        }
        if (updateMeetingRequest.getMeetingEndDate() != null) {
            this.meetingEndDate = updateMeetingRequest.getMeetingEndDate();
        }
    }

    public void increaseViewCount() {
        this.views += INCREMENT_VIEW_COUNT;
    }

    public void addComments(Comment comment) {
        comment.setMeeting(this);
        this.comments.add(comment);
    }

    public Comment getLatestComment() {
        return comments.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new MeetingExceptionHandler(ErrorCode.NOT_FOUND_COMMENT));

    }

    public Comment getCommentById(Long commentId) {
        return comments.stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst()
                .orElseThrow(() -> new MeetingExceptionHandler(ErrorCode.NOT_FOUND_COMMENT));
    }

    public void updateComment(Long commentId, UpdateCommentRequest updateCommentRequest) {
        comments.stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst()
                .ifPresent(comment -> {
                    if (updateCommentRequest.getContent() != null && !updateCommentRequest.getContent().isEmpty()) {
                        comment.setContent(updateCommentRequest.getContent());
                        comment.setUpdated(true);
                    }
                });
    }

}
