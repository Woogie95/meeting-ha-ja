package com.example.gatheringhaja.entity;

import com.example.gatheringhaja.entity.enumerations.MeetingType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime created;

    @CreatedDate
    private LocalDateTime updated;

    @CreatedDate
    private LocalDate meetingStartDate;

    @CreatedDate
    private LocalDate meetingEndDate;

    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private Set<Applicant> applicants = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

}
