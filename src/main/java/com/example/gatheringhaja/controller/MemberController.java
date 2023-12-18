package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.dto.request.CreateMemberRequest;
import com.example.gatheringhaja.dto.response.CreateMemberResponse;
import com.example.gatheringhaja.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<CreateMemberResponse> create(@RequestBody @Valid CreateMemberRequest createMemberRequest) {
        return ResponseEntity.ok(memberService.create(createMemberRequest));
    }

}
