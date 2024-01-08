package com.example.gatheringhaja.dto.request;

import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.entity.enumerations.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class SignupMemberRequest {

    @NotBlank(message = "최소 1자 이상 닉네임을 입력해주세요.")
    private String nickname;

    @Email(message = "올바른 이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotNull(message = "생년월일을 입력해 주세요.")
    @Past(message = "올바른 생년월일을 입력해 주세요.")
    private LocalDate birthDate;

    @NotNull(message = "성별을 입력해주세요.")
    private Gender gender;

    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 010-xxxx-xxxx")
    private String phoneNumber;

    private String profileImagePath;

    @Size(min = 5, max = 100, message = "최소 5자 이상, 100자 이하로 입력해주세요.")
    private String introduction;

    public Member toEntity() {
        return Member.builder()
                .nickname(this.nickname)
                .email(this.email)
                .password(this.password)
                .birthDate(this.birthDate)
                .gender(this.gender)
                .phoneNumber(this.phoneNumber)
                .profileImagePath(this.profileImagePath)
                .introduction(this.introduction)
                .build();
    }

}
