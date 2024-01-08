package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.request.UpdateMemberRequest;
import com.example.gatheringhaja.dto.response.FindAllMemberResponse;
import com.example.gatheringhaja.dto.response.FindByIdMemberResponse;
import com.example.gatheringhaja.dto.response.UpdateMemberResponse;
import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.MeetingHaJaException;
import com.example.gatheringhaja.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

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

    @Transactional
    public UpdateMemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MeetingHaJaException(ErrorCode.NOT_FOUND_MEMBER));
        if (updateMemberRequest.getPassword() != null) {
            String currentPassword = passwordEncoder.encode(updateMemberRequest.getPassword());
            member.updatePassword(currentPassword);
        }
        member.updateMemberInfo(updateMemberRequest.getNickname(), updateMemberRequest.getPhoneNumber(),
                updateMemberRequest.getIntroduction());
        return UpdateMemberResponse.from(memberRepository.save(member));
    }

    /**
     * 회원 탈퇴
     */

}
