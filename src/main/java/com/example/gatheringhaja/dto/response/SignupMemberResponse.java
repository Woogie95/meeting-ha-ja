package com.example.gatheringhaja.dto.response;

import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.entity.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupMemberResponse {

    private Long id;
    private String nickname;
    private String email;
    private String password;
    private int age;
    private Gender gender;
    private String phoneNumber;
    private String profileImagePath;
    private String introduction;
    private LocalDateTime registered;
    private boolean deleted;

    public static SignupMemberResponse from(Member member) {
        return SignupMemberResponse.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .password(member.getPassword())
                .age(member.getAge())
                .gender(member.getGender())
                .phoneNumber(member.getPhoneNumber())
                .profileImagePath(member.getProfileImagePath())
                .introduction(member.getIntroduction())
                .registered(member.getRegistered())
                .deleted(false)
                .build();
    }

}
