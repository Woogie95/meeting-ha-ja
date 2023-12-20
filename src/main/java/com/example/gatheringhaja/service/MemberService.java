package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.response.FindAllMemberResponse;
import com.example.gatheringhaja.dto.response.FindByIdMemberResponse;
import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.MeetingHaJaException;
import com.example.gatheringhaja.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public FindByIdMemberResponse findById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MeetingHaJaException(ErrorCode.NOT_FOUND_MEMBER));
        return FindByIdMemberResponse.from(member);
    }

    @Transactional(readOnly = true)
    public List<FindAllMemberResponse> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(FindAllMemberResponse::from)
                .collect(Collectors.toList());
    }

    /**
     * 회원 업데이트
     */

    /**
     * 회원 탈퇴
     */

}
