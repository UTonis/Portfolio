// 2. BoardRepository.java
package com.myportfolio.hub.repository;

import com.myportfolio.hub.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // 필요한 쿼리가 있으면 여기에 추가 (예: 제목으로 검색)
}