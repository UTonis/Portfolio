package spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.member.domain.Member;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByEmail(String email);

    @Override
    Optional<Member> findByEmailAndPassword(String email, String password);
}
