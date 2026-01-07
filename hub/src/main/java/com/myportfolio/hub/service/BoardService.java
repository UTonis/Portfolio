package com.myportfolio.hub.service;

import com.myportfolio.hub.domain.Board;
import com.myportfolio.hub.domain.Member;
import com.myportfolio.hub.repository.BoardRepository;
import com.myportfolio.hub.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 게시글 작성
    public Board write(String userId, String title, String content) {
        // 1. 작성자 찾기
        Member member = memberRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        // 2. 게시글 생성
        Board board = Board.builder()
                .title(title)
                .content(content)
                .member(member) // 작성자 연결
                .createdAt(LocalDateTime.now())
                .build();

        // 3. 저장
        return boardRepository.save(board);
    }

    // 게시글 전체 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}