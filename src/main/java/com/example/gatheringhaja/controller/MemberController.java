package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.dto.MessageResponse;
import com.example.gatheringhaja.dto.request.UpdateMemberRequest;
import com.example.gatheringhaja.dto.response.FindAllMeetingResponse;
import com.example.gatheringhaja.dto.response.FindAllMemberResponse;
import com.example.gatheringhaja.dto.response.FindByIdMemberResponse;
import com.example.gatheringhaja.dto.response.UpdateMemberResponse;
import com.example.gatheringhaja.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<FindByIdMemberResponse> findById(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(FindByIdMemberResponse.from(memberService.findById(memberId)));
    }

    @GetMapping
    public ResponseEntity<List<FindAllMemberResponse>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{memberId}/meetings")
    public ResponseEntity<List<FindAllMeetingResponse>> findAllMeetingsByMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.findAllMeetingsByMember(memberId));
    }


    @PutMapping("/{memberId}")
    public ResponseEntity<UpdateMemberResponse> update(@PathVariable("memberId") Long memberId,
                                                       @RequestBody @Valid UpdateMemberRequest updateMemberRequest) {
        return ResponseEntity.ok(memberService.update(memberId, updateMemberRequest));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("memberId") Long memberId) {
        memberService.delete(memberId);
        return new ResponseEntity<>(MessageResponse.from(MessageResponse.MEMBER_DELETED), HttpStatus.OK);
    }

}