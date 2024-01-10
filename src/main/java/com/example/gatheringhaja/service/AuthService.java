package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.request.SignInMemberRequest;
import com.example.gatheringhaja.dto.request.SignupMemberRequest;
import com.example.gatheringhaja.dto.response.SignupMemberResponse;
import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.exception.MeetingHaJaException;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.member.MemberExceptionHandler;
import com.example.gatheringhaja.repository.MemberRepository;
import com.example.gatheringhaja.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Long EXPIRE_TIME_MS = 1000 * 60 * 60L;

    @Value("${jwt.token.secret}")
    private String secretKey;

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Transactional
    public SignupMemberResponse signup(SignupMemberRequest signupMemberRequest) {
        memberRepository.findByEmail(signupMemberRequest.getEmail())
                .ifPresent(email -> {
                    throw new MemberExceptionHandler(ErrorCode.DUPLICATE_EMAIL);
                });
        Member member = signupMemberRequest.toEntity();
        member.setPassword(passwordEncoder.encode(signupMemberRequest.getPassword()));
        return SignupMemberResponse.from(memberRepository.save(member));
    }

    public String signIn(SignInMemberRequest signInMemberRequest) {
        Member member = memberRepository.findByEmail(signInMemberRequest.getEmail())
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.NOT_FOUND_EMAIL));
        if (!passwordEncoder.matches(signInMemberRequest.getPassword(), member.getPassword())) {
            throw new MeetingHaJaException(ErrorCode.INVALID_PASSWORD);
        }
        return JwtTokenUtil.createToken(member.getEmail(), secretKey, EXPIRE_TIME_MS);
    }

}
