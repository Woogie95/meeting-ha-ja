package com.example.gatheringhaja.dto;

import com.example.gatheringhaja.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentPayload {

    private static final boolean DEFAULT_IS_UPDATED = false;

    private Long id;
    private String content;
    private boolean isUpdated;
    private Long meetingId;
    private Long memberId;
    private LocalDate created;
    private LocalDate updated;

    public static CommentPayload from(Comment comment) {
        return CommentPayload.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .isUpdated(DEFAULT_IS_UPDATED)
                .meetingId(comment.getMeeting().getId())
                .memberId(comment.getMemberId())
                .created(comment.getCreated())
                .updated(comment.getUpdated())
                .build();
    }

}
