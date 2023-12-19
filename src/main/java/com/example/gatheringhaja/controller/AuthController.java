package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.dto.request.SignupMemberRequest;
import com.example.gatheringhaja.dto.request.SignInMemberRequest;
import com.example.gatheringhaja.dto.response.SignupMemberResponse;
import com.example.gatheringhaja.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<SignupMemberResponse> signup(@RequestBody @Valid SignupMemberRequest signupMemberRequest) {
        return ResponseEntity.ok(authService.signup(signupMemberRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid SignInMemberRequest signInMemberRequest) {
        return ResponseEntity.ok().body(authService.signIn(signInMemberRequest));
    }

}
