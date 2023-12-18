package com.example.gatheringhaja.service;

import com.example.gatheringhaja.dto.request.CreateMeetingRequest;
import com.example.gatheringhaja.dto.response.CreateMeetingResponse;
import com.example.gatheringhaja.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

    @Transactional
    public CreateMeetingResponse create(CreateMeetingRequest createMeetingRequest) {
        return CreateMeetingResponse.from(meetingRepository.save(createMeetingRequest.toEntity()));
    }

}
