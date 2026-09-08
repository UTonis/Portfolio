package spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.member.domain.Member;
import spring.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getEmail();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m->{
                    throw  new IllegalStateException(("이미 존재하는 회원입니다."));
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberEmail){
        return memberRepository.findByEmail(memberEmail);
    }

    public Optional<Member> Login(String email, String password){
        return memberRepository.findByEmailAndPassword(email, password);
    }
}
