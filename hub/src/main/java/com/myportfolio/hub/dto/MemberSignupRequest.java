package com.myportfolio.hub.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignupRequest {
    private String userId;
    private String password;
    private String name;
    private String phone;
    private String email;
}
