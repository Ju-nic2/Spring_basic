package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//진짜 좋은 테스트는 Spring올리지 않은 단위 테스트. -> 잘 만드는거 중요
@SpringBootTest
//Test 시작시 Transaction 수행, 후 Test끝나면 모두 롤백해줌
@Transactional
class MemberServiceIntTest {

    //Spring 과 통합 테스트 하기위해 DI 해야함. ( 가장 편하게 )
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;



    @Test
    void join() {
        //given 뭔가 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when 이걸 실행했을때
        Long saveId = memberService.join(member);

        //then 결과로 이게 나와야함.
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());

    }

    @Test
    public void duplicatedMemgerException()
    {
        Member member1 = new Member();
        member1.setName("junic22");

        Member member2 = new Member();
        member2.setName("junic22");

        memberService.join(member1);

        // member2 를 넣었을때 ill~~ 예외가 터져야함.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertEquals(e.getMessage(),"이미 존재");
        /*
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            Assertions.assertEquals(e.getMessage(),"이미 존재");
        }*/


    }

}