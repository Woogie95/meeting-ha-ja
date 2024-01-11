package com.example.gatheringhaja.entity;

import com.example.gatheringhaja.dto.request.UpdateMeetingRequest;
import com.example.gatheringhaja.entity.enumerations.MeetingType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Meeting {

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

    @CreatedDate
    private LocalDate created;

    @LastModifiedDate
    private LocalDate updated;

    private LocalDate meetingStartDate;

    private LocalDate meetingEndDate;

    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
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

}
