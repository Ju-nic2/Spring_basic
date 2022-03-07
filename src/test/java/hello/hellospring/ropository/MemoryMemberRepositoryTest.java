package hello.hellospring.ropository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // method 끝날때 마다 호출 됨 .
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("junic");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        //오류 Test
        Assertions.assertEquals(member,result);
        System.out.println("result = " + (result == member));

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("junic1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("junic2");
        repository.save(member2);

        repository.findByName("junic2");
        Member result = repository.findByName("junic2").get();

        Assertions.assertEquals(member2,result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("junic1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("junic2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(2,result.size());
    }


}
