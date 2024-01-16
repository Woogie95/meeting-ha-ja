package com.example.gatheringhaja.dto.response;

import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.entity.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberResponse {

    private Long id;
    private String nickname;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String profileImagePath;
    private String introduction;
    private LocalDate created;
    private LocalDate updated;
    private boolean deleted;

    public static UpdateMemberResponse from(Member member) {
        return UpdateMemberResponse.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .password(member.getPassword())
                .birthDate(member.getBirthDate())
                .gender(member.getGender())
                .phoneNumber(member.getPhoneNumber())
                .profileImagePath(member.getProfileImagePath())
                .introduction(member.getIntroduction())
                .created(member.getCreated())
                .updated(member.getUpdated())
                .deleted(false)
                .build();
    }

}
