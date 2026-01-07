package com.myportfolio.hub.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members") // 테이블 이름을 명시적으로 'members'로 지정
@Getter @Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
@Builder // 빌더 패턴 사용 (객체 생성을 편하게)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(unique = true, nullable = false)
    private String userId; // 아이디

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private String phone; // 전화번호

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private java.time.LocalDateTime joinedAt; // 회원가입 날짜
}