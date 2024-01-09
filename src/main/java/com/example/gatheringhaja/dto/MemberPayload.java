package com.example.gatheringhaja.dto;

import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.entity.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPayload {

    private Long id;
    private String nickname;
    private String email;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String introduction;
    private LocalDateTime registered;
    private boolean deleted;

    public Member toEntity() {
        return Member.builder()
                .id(this.id)
                .nickname(this.nickname)
                .email(this.email)
                .birthDate(this.birthDate)
                .gender(this.gender)
                .phoneNumber(this.phoneNumber)
                .introduction(this.introduction)
                .registered(this.registered)
                .deleted(this.deleted)
                .build();
    }

    public static MemberPayload from(Member member) {
        return MemberPayload.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .birthDate(member.getBirthDate())
                .gender(member.getGender())
                .phoneNumber(member.getPhoneNumber())
                .introduction(member.getIntroduction())
                .registered(member.getRegistered())
                .deleted(member.isDeleted())
                .build();
    }

}
