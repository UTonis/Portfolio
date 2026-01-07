package com.myportfolio.hub.controller;

import com.myportfolio.hub.dto.MemberLoginRequest;
import com.myportfolio.hub.dto.MemberResponse;
import com.myportfolio.hub.dto.MemberSignupRequest;
import com.myportfolio.hub.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody MemberSignupRequest request) {
        return ResponseEntity.ok(memberService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponse> login(@RequestBody MemberLoginRequest request) {
        return ResponseEntity.ok(memberService.login(request));
    }
}
