package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
                                                        // 내부에서 기본적인 findAll save 같은거 제공함
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    // 공통화 안된 메소드는 말해줘야함
    @Override

    // Select m from Member m where m.name = ? 이런 규칙에 따라 쿼리 짜줌.
    Optional<Member> findByName(String name);
}
