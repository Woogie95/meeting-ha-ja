package com.example.gatheringhaja.dto.response;

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
public class UpdateCommentResponse {

    private Long id;
    private String content;
    private boolean isUpdated;
    private Long memberId;
    private LocalDate created;
    private LocalDate updated;

    public static UpdateCommentResponse from(Comment comment) {
        return UpdateCommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .isUpdated(comment.isUpdated())
                .memberId(comment.getMemberId())
                .created(comment.getCreated())
                .updated(comment.getUpdated())
                .build();
    }

}
