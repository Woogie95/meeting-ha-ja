package com.example.gatheringhaja.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateMemberRequest {

    @Size(min = 2, message = "닉네임은 최소 2자 이상이어야 합니다.")
    private String nickname;

    @Size(min = 4, message = "비밀번호는 최소 4자 이상이어야 합니다.")
    private String password;

    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 010-xxxx-xxxx")
    private String phoneNumber;

    @Size(min = 5, max = 100, message = "최소 5자 이상, 100자 이하로 입력해주세요.")
    private String introduction;

}
