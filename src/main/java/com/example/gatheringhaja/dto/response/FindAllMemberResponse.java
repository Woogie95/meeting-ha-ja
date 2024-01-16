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
public class FindAllMemberResponse {

    private static final boolean DEFAULT_IS_DELETED = false;

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
    private boolean isDeleted;

    public static FindAllMemberResponse from(Member member) {
        return FindAllMemberResponse.builder()
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
                .isDeleted(DEFAULT_IS_DELETED)
                .build();
    }

}
