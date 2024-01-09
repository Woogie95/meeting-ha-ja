package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.MemberPayload;
import com.example.gatheringhaja.dto.request.CreateMeetingRequest;
import com.example.gatheringhaja.dto.response.CreateMeetingResponse;
import com.example.gatheringhaja.entity.Meeting;
import com.example.gatheringhaja.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MemberService memberService;
    private final MeetingRepository meetingRepository;

    @Transactional
    public CreateMeetingResponse create(CreateMeetingRequest createMeetingRequest) {
        MemberPayload memberPayload = memberService.findById(createMeetingRequest.getMemberId());
        Meeting meeting = createMeetingRequest.toEntity();
        meeting.setMember(memberPayload.toEntity());
        return CreateMeetingResponse.from(meetingRepository.save(meeting));
    }

}
