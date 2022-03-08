# Spring_basic
Basic spring study    

# Wep App 계층구조 
Controller : MVC의 컨트롤러 역할, get,post로 호출 받고 -> 로직처리 -> 리턴(templates or 정적파일)     
Service : 비지니스 핵심 로직 구현 , -> Data 처리 로직 구현되어있는 객체    
Repository : DB 접근, 도메인 객체를 DB 저장    
Domain : 비즈니스 도메인 객체 -> Data 틀    

# Spring MVC Model
Model : 데이터의 모든 정보를 가공하여 가지고 있는 컴포넌트    
View : 시각적인 요소 제공    
Controller : 모델과 View 연결     
== Django 로 따지면 views.py   
== Nodejs 에선 routes 같음    

# Spring Bean 
Application Context가 관리하는 객체 
Spring은 객체간의 결합을 코딩 하는것이 아니라 Container로 처리함. -> 결합도 낮춰 편리함 제공    
대신 @Autowired나 Component를 직접 작성 할 수 있도록 하여 의존성 주입 기능 제공    
-> 직접 구조 짜면서 좀더 공부 해야할꺼 같음    
(국룰 : Confing 만들어서 따로 명시해둠 -> 클래스 변경시 편함)     

## Dependency Injection 
Spring Container내에 생성되어있는 객체들의 의존성을 주입함 (잘 모르겠음) 
(국룰 : 생성자 주입)    
