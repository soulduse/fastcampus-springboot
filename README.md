# 패스트캠퍼스 SpringBoot 교육


# [1 주차] 

- COC - 니가 알다시피
    - 디렉토리가 같으면 익숙하다. 
    - 이미 알고 있다면 좋은 개념.
    - 익숙하기 전까지는 힘들다.
- 회사에 소속 되어있다면 빌드도구 하나쯤은 잘 사용할 줄 알아야 한다.
- Maven, Gralde, etc
- 하나의 스프링 프로젝트는 여러개의 모듈로 구성됨.

### pom.xml
<시작tag>내용</종료tag>
> Element(요소)
- XML문서 정의 : DTD, XML스키마
- Valid XML : 스키마에 맞게 작성된 문서

<상품:name>
<회원:name>

- 여러개의 모듈이 공통적인 속성을 가져다 쓸 수 있음. 이때 `<parent>..</parent>`를 사용할 수 있다.

### 제목
- Gradle: org.springframework.boot:spring-boot-autoconfigure:2.1.1.RELEASE > 
- @Configuration : 설정파일 클래스
- DispatcherServletAutoConfiguration

### Bean 컨테이너
- BeanFactory
    - 빈 컨테이너중 가장 작은 기능만 가지고 있다. (의존성 주입만 가지고 있음)
    - 보통은 이것만 단독으로 안쓰임
- ApplicationContext
    - 어떤 객체를 내부적으로 생성하고, 만들어진 객체를 사용자에게 준다.
    - 자기가 만든 객체를 주는 무엇인가가 있어야 한다.
- WebApplicationContext
- Configuration을 클래스로 만들때, 메소드명을 중복해서 사용하면 문제가 된다. 메소드 명으로 Bean Container Id로 사용하기 때문이다.
    - 자바에서는 메소드 오버로딩이 되기 때문에 문제가 없지만 빈에서는 문제가됨.
- @Bean 메소드에 파라미터가 있으면 나중에 실행된다.  



### 프로그래밍 만들기
- 기능정의, 기능구현중 기능정의가 더 먼저
- 프로그래밍은 키보드에 손을 올리고 짜는게 아니다.
- 구현하기전 스케치를 해야한다.(책 추천 : UML DISTILLED)

### 학습할 기초 내용
- Java8
- SQL
- JDBC 개념 알아두기
    - PreparedStatement  
    - 입력,수정,삭제
- HTML / CSS
- HTTP 프로토콜
    - 서블릿 / JSP 개념
    - 라이프사이클
    - 주요객체

### 스프링 관련 학습할 내용
- Spring core
    - Spring MVC
    - Spring Data JPA
    - Spring JDBC
- Template Engine
    - JSP
    - Thymeleaf
    - Freemarker
    - etc
- Spring Boot
- Build, Release, Test
    - 자동화
- Bean 컨테이너

### 수업 앞으로의 방향
- 본인이 계속 운영할 서비스를 만들어보면 좋겠다.
- 커뮤니티, 블로그, 기타 등등
    
### 숙제
```java
public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        CompactDisc compactDisc1 = context.getBean("compactDisc", CompactDisc.class);
        CompactDisc compactDisc2 = context.getBean("compactDisc", CompactDisc.class);
        if(compactDisc1 == compactDisc2){
            System.out.println("compactDisc1 == dompactDisc2");
        }

        CompactDisc myDisc = context.getBean("myDisc", CompactDisc.class);
        myDisc.play();

        CDPlayer cdPlayer = context.getBean("cdPlayer", CDPlayer.class);
        cdPlayer.play();
    }
}

```
1. Bean 컨테이너 만들기
    - ApplicationContext ctx = new ....
2. getBean(id)
3. 같은 참조인가 비교 
    - Singleton 인지 아닌지 찾아보기
