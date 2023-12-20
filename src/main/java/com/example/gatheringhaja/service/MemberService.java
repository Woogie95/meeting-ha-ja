package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.response.FindByIdMemberResponse;
import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.MeetingHaJaException;
import com.example.gatheringhaja.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public FindByIdMemberResponse findById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->  new MeetingHaJaException(ErrorCode.NOT_FOUND_MEMBER));
        return FindByIdMemberResponse.from(member);
    }


    /**
     * 회원 전제 조회
     */


    /**
     * 회원 업데이트
     */

    /**
     * 회원 탈퇴
     */

}
