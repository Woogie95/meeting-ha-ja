package com.example.gatheringhaja.dto.request;

import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.entity.enumerations.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@Getter
@Builder
@AllArgsConstructor
public class CreateMemberRequest {

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull(message = "숫자로 올바른 나이를 입력해 주세요.")
    private int age;

    @NotNull
    private Gender gender;

    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxxx-xxxx")
    private String phoneNumber;

    private String profileImagePath; // 프로필이미지 S3 STORAGE??? 적용

    @Size(min = 5, max = 100, message = "최소 5자 이상, 100자 이하로 입력해주세요.")
    private String introduction;

    public Member toEntity() {
        return Member.builder()
                .email(this.email)
                .password(this.password)
                .age(this.age)
                .gender(this.gender)
                .phoneNumber(this.phoneNumber)
                .profileImagePath(this.profileImagePath)
                .introduction(this.introduction)
                .build();
    }

}
