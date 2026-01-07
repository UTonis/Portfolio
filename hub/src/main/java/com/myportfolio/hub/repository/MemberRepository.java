// 1. MemberRepository.java
package com.myportfolio.hub.repository;

import com.myportfolio.hub.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserId(String userId); // 아이디로 회원 찾기
}