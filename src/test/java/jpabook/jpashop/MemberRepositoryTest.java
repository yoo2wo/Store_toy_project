package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    void testMember(){
        //given
        Member member = new Member();
        member.setUsername("AA");
        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(member.getId());
        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }
}