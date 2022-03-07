package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
   /* MemberService memberService = new MemoryMemberRepository();;
    MemoryMemberRepository memberRepository =  new MemberService();*/
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // method 끝날때 마다 호출 됨 .

    //  각 test 실행전 실행
    // 같은 memoryRepository 사용 가능
    // Dependency injection
    @BeforeEach
    public void beforEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }



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
        member1.setName("junic");

        Member member2 = new Member();
        member2.setName("junic");

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

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}