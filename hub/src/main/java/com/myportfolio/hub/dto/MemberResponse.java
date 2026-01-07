package com.myportfolio.hub.dto;

import com.myportfolio.hub.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Long pk;
    private String userId;
    private String name;
    private String email;

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .pk(member.getPk())
                .userId(member.getUserId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
