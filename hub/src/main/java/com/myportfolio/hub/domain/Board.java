package com.myportfolio.hub.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   // 제목

    @Column(columnDefinition = "TEXT") // 긴 내용 저장
    private String content; // 내용

    private LocalDateTime createdAt; // 작성 시간

    // ★ 핵심: 작성자(Member)와 연결 (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}