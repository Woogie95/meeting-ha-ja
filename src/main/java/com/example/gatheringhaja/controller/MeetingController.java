package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.dto.request.CreateMeetingRequest;
import com.example.gatheringhaja.dto.response.CreateMeetingResponse;
import com.example.gatheringhaja.service.MeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public CreateMeetingResponse create(@RequestBody @Valid CreateMeetingRequest createMeetingRequest) {
        return meetingService.create(createMeetingRequest);
    }

}
