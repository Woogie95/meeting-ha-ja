package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.request.SignInMemberRequest;
import com.example.gatheringhaja.dto.request.SignupMemberRequest;
import com.example.gatheringhaja.dto.response.SignupMemberResponse;
import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.exception.DuplicateEmailException;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public SignupMemberResponse signup(SignupMemberRequest signupMemberRequest) {
        memberRepository.findByEmail(signupMemberRequest.getEmail())
                .ifPresent(email -> {
                    throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL);
                });
        Member member = signupMemberRequest.toEntity();
        member.setPassword(passwordEncoder.encode(signupMemberRequest.getPassword()));
        return SignupMemberResponse.from(memberRepository.save(member));
    }

    public String signIn(SignInMemberRequest signInMemberRequest) {

        return "";

    }


}
