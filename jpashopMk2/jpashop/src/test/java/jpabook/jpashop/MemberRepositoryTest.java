package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    void save() {
        Member member=new Member();
        member.setUsername("D");

        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        Assertions.assertEquals(member.getUsername(),findMember.getUsername());

    }

    @Test
    void find() {
    }
}