package spring.member.service;

import spring.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.member.repository.MemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("홍길동");
        member.setEmail("example@email.com");
        member.setPassword("1234");

        //when
        String saveEmail = memberService.join(member);

        //then
        Member findMemeber = memberService.findOne(saveEmail).get();
        assertThat(member.getName()).isEqualTo(findMemeber.getName());
    }

    @Test
    void 중복회원에외() {
        //given
        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setEmail("example@email.com");
        member1.setPassword("1234");

        Member member2 = new Member();
        member2.setName("엄준식");
        member2.setEmail("example@email.com");
        member2.setPassword("qwer");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo(("이미 존재하는 회원입니다."));
    }
}
