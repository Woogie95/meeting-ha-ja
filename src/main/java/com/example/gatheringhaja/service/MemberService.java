package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.request.CreateMemberRequest;
import com.example.gatheringhaja.dto.response.CreateMemberResponse;
import com.example.gatheringhaja.entity.Member;
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
        return CreateMemberResponse.from(memberRepository.save(createMemberRequest.toEntity()));
    }

}
