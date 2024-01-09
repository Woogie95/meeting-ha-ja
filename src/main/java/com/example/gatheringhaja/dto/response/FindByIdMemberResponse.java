package com.example.gatheringhaja.dto.response;

import com.example.gatheringhaja.dto.MemberPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindByIdMemberResponse {

    private MemberPayload memberPayload;

    public static FindByIdMemberResponse from(MemberPayload memberPayload) {
        return FindByIdMemberResponse.builder()
                .memberPayload(memberPayload)
                .build();
    }

}
