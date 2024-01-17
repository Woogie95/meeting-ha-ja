package com.example.gatheringhaja.controller;

import com.example.gatheringhaja.dto.MessageResponse;
import com.example.gatheringhaja.dto.request.CreateCommentRequest;
import com.example.gatheringhaja.dto.request.CreateMeetingRequest;
import com.example.gatheringhaja.dto.request.UpdateCommentRequest;
import com.example.gatheringhaja.dto.request.UpdateMeetingRequest;
import com.example.gatheringhaja.dto.response.*;
import com.example.gatheringhaja.service.MeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/{meetingId}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("meetingId") Long meetingId) {
        meetingService.delete(meetingId);
        return new ResponseEntity<>(MessageResponse.from(MessageResponse.MEETING_DELETED), HttpStatus.OK);
    }

    @PostMapping("/{meetingId}/comments")
    public ResponseEntity<CreateCommentResponse> createComment(@PathVariable("meetingId") Long meetingId,
                                                               @RequestBody @Valid CreateCommentRequest createCommentRequest) {
        return ResponseEntity.ok(meetingService.createComment(meetingId, createCommentRequest));
    }

    @PutMapping("/{meetingId}/{commentId}")
    public ResponseEntity<UpdateCommentResponse> updateComment(@PathVariable("meetingId") Long meetingId,
                                                               @PathVariable("commentId") Long commentId,
                                                               @RequestBody @Valid UpdateCommentRequest updateCommentRequest) {
        return ResponseEntity.ok(meetingService.updateComment(meetingId, commentId, updateCommentRequest));
    }

}
