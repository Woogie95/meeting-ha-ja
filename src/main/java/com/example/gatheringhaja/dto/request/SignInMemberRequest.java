package com.example.gatheringhaja.dto.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInMemberRequest {

    @Email
    private String email;

    private String password;

}
