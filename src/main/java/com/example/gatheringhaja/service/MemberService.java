package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.request.CreateMemberRequest;
import com.example.gatheringhaja.dto.response.CreateMemberResponse;
import com.example.gatheringhaja.exception.DuplicateEmailException;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse create(CreateMemberRequest createMemberRequest) {
        memberRepository.findByEmail(createMemberRequest.getEmail())
                .ifPresent(email -> {
                    throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL);
                });
        return CreateMemberResponse.from(memberRepository.save(createMemberRequest.toEntity()));
    }

}
