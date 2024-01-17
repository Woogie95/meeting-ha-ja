package com.example.gatheringhaja.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UpdateCommentRequest {

    @Size(min = 5, message = "내용은 최소 5자 이상 입력해주세요.")
    private String content;

    @NotNull(message = "사용자 ID는 null 일 수 없습니다.")
    private Long memberId;

}
