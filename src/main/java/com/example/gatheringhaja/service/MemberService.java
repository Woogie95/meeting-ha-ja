package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.MemberPayload;
import com.example.gatheringhaja.dto.request.UpdateMemberRequest;
import com.example.gatheringhaja.dto.response.FindAllMemberResponse;
import com.example.gatheringhaja.dto.response.UpdateMemberResponse;
import com.example.gatheringhaja.entity.Member;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.member.MemberExceptionHandler;
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
    public MemberPayload findById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.NOT_FOUND_MEMBER));
        return MemberPayload.from(member);
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
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.NOT_FOUND_MEMBER));
        if (updateMemberRequest.getPassword() != null) {
            String currentPassword = passwordEncoder.encode(updateMemberRequest.getPassword());
            member.updatePassword(currentPassword);
        }
        member.updateMemberInfo(updateMemberRequest.getNickname(), updateMemberRequest.getPhoneNumber(),
                updateMemberRequest.getIntroduction());
        return UpdateMemberResponse.from(memberRepository.save(member));
    }

    @Transactional
    public void delete(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.NOT_FOUND_MEMBER));
        if (member.isDeleted()) {
            throw new MemberExceptionHandler(ErrorCode.ALREADY_DELETED_MEMBER);
        }
        member.deleteMember();
    }

}
