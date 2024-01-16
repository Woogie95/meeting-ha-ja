package com.example.gatheringhaja.dto.request;

import com.example.gatheringhaja.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateCommentRequest {

    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 1, message = "내용은 최소 1자 이상 입력해주세요.")
    private String content;

    @NotNull(message = "사용자 ID 를 입력해주세요.")
    private Long memberId;

    public Comment toEntity() {
        return Comment.builder()
                .content(this.content)
                .memberId(this.memberId)
                .build();
    }

}
