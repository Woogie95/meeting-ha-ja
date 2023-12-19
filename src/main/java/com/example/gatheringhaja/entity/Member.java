package com.example.gatheringhaja.entity;

import com.example.gatheringhaja.entity.enumerations.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    private String password;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    private String profileImagePath; // 프로필이미지 S3 STORAGE??? 적용

    private String introduction;

    @CreatedDate
    private LocalDateTime registered;

    private boolean deleted;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<Meeting> meetings = new HashSet<>();

}
