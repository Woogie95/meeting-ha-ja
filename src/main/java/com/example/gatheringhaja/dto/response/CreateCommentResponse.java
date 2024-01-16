package com.example.gatheringhaja.dto.response;

import com.example.gatheringhaja.dto.CommentPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentResponse {

    private CommentPayload commentPayload;

    public static CreateCommentResponse from(CommentPayload commentPayload) {
        return CreateCommentResponse.builder()
                .commentPayload(commentPayload)
                .build();
    }

}
