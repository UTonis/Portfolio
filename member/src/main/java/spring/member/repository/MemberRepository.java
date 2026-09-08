package spring.member.repository;

import spring.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
    Optional<Member> findByEmailAndPassword(String email, String password);
}
