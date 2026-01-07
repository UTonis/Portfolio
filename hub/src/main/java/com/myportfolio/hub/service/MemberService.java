package com.myportfolio.hub.service;

import com.myportfolio.hub.domain.Member;
import com.myportfolio.hub.dto.MemberLoginRequest;
import com.myportfolio.hub.dto.MemberResponse;
import com.myportfolio.hub.dto.MemberSignupRequest;
import com.myportfolio.hub.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String signup(MemberSignupRequest request) {
        // 아이디 중복 검사
        if (memberRepository.findByUserId(request.getUserId()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 회원 저장
        Member member = Member.builder()
                .userId(request.getUserId())
                .password(encodedPassword)
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .joinedAt(java.time.LocalDateTime.now())
                .build();

        memberRepository.save(member);
        
        return "회원가입 성공";
    }

    public MemberResponse login(MemberLoginRequest request) {
        // 회원 조회
        Member member = memberRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        // 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return MemberResponse.from(member);
    }
}
