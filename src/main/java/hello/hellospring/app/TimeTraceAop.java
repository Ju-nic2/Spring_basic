package hello.hellospring.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


//AOP = 공통 관심사항인 시간측정 로직 편리하게 관리
@Aspect
@Component
public class TimeTraceAop {
    // 적용 범위 설정. 원하는 package ~ 파라미터~등등
    @Around("execution(* hello.hellospring..*(..))")
    //!target(hello.hellospring.SpringConfig)" -> config에 직접 Bean등록시 발생하는 순환참조 오류 해결법법
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Start : " + joinPoint.toString());
        try {
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("end " + joinPoint.toString() +" "+timeMs +"ms");
        }
    }
}
