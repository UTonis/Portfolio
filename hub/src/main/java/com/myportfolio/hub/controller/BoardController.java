package com.myportfolio.hub.controller;

import com.myportfolio.hub.domain.Board;
import com.myportfolio.hub.dto.BoardRequest;
import com.myportfolio.hub.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 쓰기
    @PostMapping
    public String create(@RequestBody BoardRequest request) {
        boardService.write(request.getUserId(), request.getTitle(), request.getContent());
        return "게시글 작성 성공!";
    }

    // 게시글 목록 보기
    @GetMapping
    public List<Board> list() {
        return boardService.getAllBoards();
    }
}