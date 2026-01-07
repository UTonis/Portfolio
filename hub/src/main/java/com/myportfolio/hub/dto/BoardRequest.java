// BoardRequest.java
package com.myportfolio.hub.dto;
import lombok.Data;

@Data
public class BoardRequest {
    private String userId; // 작성자 아이디 (로그인 구현 전이라 임시로 받음)
    private String title;
    private String content;
}