package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.MemberPayload;
import com.example.gatheringhaja.dto.request.CreateMeetingRequest;
import com.example.gatheringhaja.dto.request.UpdateMeetingRequest;
import com.example.gatheringhaja.dto.response.*;
import com.example.gatheringhaja.entity.Meeting;
import com.example.gatheringhaja.exception.ErrorCode;
import com.example.gatheringhaja.exception.meeting.MeetingExceptionHandler;
import com.example.gatheringhaja.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public FindByIdMeetingResponse findById(Long meetingId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingExceptionHandler(ErrorCode.NOT_FOUND_MEETING));
        return FindByIdMeetingResponse.from(meeting);
    }

    @Transactional(readOnly = true)
    public List<FindAllMeetingResponse> findAll() {
        return meetingRepository.findAll().stream()
                .map(FindAllMeetingResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public UpdateMeetingResponse update(Long meetingId, UpdateMeetingRequest updateMeetingRequest) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingExceptionHandler(ErrorCode.NOT_FOUND_MEETING));
        if (!meeting.getMember().getId().equals(updateMeetingRequest.getMemberId())) {
            throw new MeetingExceptionHandler(ErrorCode.NO_AUTHORITY);
        }
        meeting.updateMeetingInfo(updateMeetingRequest);
        return UpdateMeetingResponse.from(meetingRepository.save(meeting));
    }

}