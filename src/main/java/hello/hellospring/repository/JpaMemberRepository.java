package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional // 항상 Transactional 필요함.
public class JpaMemberRepository implements MemberRepository{

    //Spring Boot 가 property 정보 + setting 정보다 해서 EntityManager만들어줌
    private final EntityManager em;

    // 역시 주입해서 써야함.
    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // 이것만 하면 insert 다해줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable( em.find(Member.class,id ));
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체 대상으로 query 만들 수 있음 , m == 객체 자체를 select 함
        List<Member> result = em.createQuery("select m from Member m",Member.class).getResultList();
        return result;
    }
}
