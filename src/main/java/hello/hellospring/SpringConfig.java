package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//Controller 는 냅둬

//자바 코드로 직접 Spring Bean 등록하기.
@Configuration
public class SpringConfig {
    /*
    //Spring Boot가 Spring Container에 App.properties 파일에 적힌 DB 를 Bean으로 가지고 잇음
    private final DataSource dataSource;
    //Dependency Injection으로 연결.
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
    //Spring Container에 Bean 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    //Spring Container에 Bean 등록
    @Bean
    public MemberRepository memberRepository(){
        // Return 값만 바꿔도됨 왜 ? MemberService는 InterFace인 MemberRepository 인스턴수 변수를 가지고 있기 때문(다형성)
        // 객체지향적 설계 굳굳
        // 개방 폐쇄 원칙
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
