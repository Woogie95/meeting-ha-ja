package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.dto.request.CreateMeetingRequest;
import com.example.gatheringhaja.dto.request.UpdateMeetingRequest;
import com.example.gatheringhaja.dto.response.CreateMeetingResponse;
import com.example.gatheringhaja.dto.response.FindAllMeetingResponse;
import com.example.gatheringhaja.dto.response.FindByIdMeetingResponse;
import com.example.gatheringhaja.dto.response.UpdateMeetingResponse;
import com.example.gatheringhaja.service.MeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public ResponseEntity<CreateMeetingResponse> create(@RequestBody @Valid CreateMeetingRequest createMeetingRequest) {
        return ResponseEntity.ok(meetingService.create(createMeetingRequest));
    }

    @GetMapping("/{meetingId}")
    public ResponseEntity<FindByIdMeetingResponse> findById(@PathVariable("meetingId") Long meetingId) {
        return ResponseEntity.ok(meetingService.findById(meetingId));
    }

    @GetMapping
    public ResponseEntity<List<FindAllMeetingResponse>> findAll() {
        return ResponseEntity.ok(meetingService.findAll());
    }

    @PutMapping("/{meetingId}")
    public ResponseEntity<UpdateMeetingResponse> update(@PathVariable("meetingId") Long meetingId,
                                                        @RequestBody @Valid UpdateMeetingRequest updateMeetingRequest) {
        return ResponseEntity.ok(meetingService.update(meetingId, updateMeetingRequest));
    }

}
