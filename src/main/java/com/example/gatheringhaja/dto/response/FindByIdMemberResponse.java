package com.example.gatheringhaja.dto.response;

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
public class FindByIdMemberResponse {

    private Long id;
    private String nickname;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String profileImagePath;
    private String introduction;
    private LocalDateTime registered;
    private boolean deleted;

    public static FindByIdMemberResponse from(Member member) {
        return FindByIdMemberResponse.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .password(member.getPassword())
                .birthDate(member.getBirthDate())
                .phoneNumber(member.getPhoneNumber())
                .profileImagePath(member.getProfileImagePath())
                .introduction(member.getIntroduction())
                .registered(member.getRegistered())
                .deleted(false)
                .build();
    }

}
