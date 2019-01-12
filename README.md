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
    
# [2 주차]

### 웹어플리케이션, WAS
1. 접속
2. 요청정보
    - HttpServletRequest 
        - DefaultServlet : 
        - Context Path > PATH 
            - 리소스 : 정적 리소스 (HTML, CSS)
            - 서블릿 : Path 값을 가지고 있어야한다. web.xml, 자바설정
            - JSP(서블릿 기술이 사용된다.)
    - HttpServletResponse
    - 서블릿이 무엇인지 이해를 하고 넘어가야 한다.
   
### 서블릿    
- HttpServlet 추상클래스 
    - init()
    - service(request, response)
    - destroy()
    - doGet()
    - doPost()
    - doPut()
    - doDelete()
    - etc .. 
    
HttpServlet은 추상클래스이기 때문에 사용시 상속받아서 구현한다.
```kotlin
@WebServlet("/hello")
class HelloServlet: HttpServlet() {
    // ...
}
```
요청이 오면 WAS가 호출해준다.
> [메모리에 없을 경우]
- 메모리에 없으면 인스턴스 생성된다.
- 서블릿이 가지고 있는 init() 함수를 호출해줌.
- init 메소드를 오버라이딩 해놨다면, 오버라이딩된 메소드가 실행된다.

> 대부분의 프로그램은 아래의 방법으로 실행된다. 
- 입력(Request) > 실행 > 결과 출력(Response)
- 스프링에서는 DispatcherServlet을 기본적으로 제공한다.

----
1) lombok을 사용하기 위한 설정을 Intellij에서 한다.
    - lombok plugin을 설치
    - 환경설정 lombok설정을 한다.
2) base 패키지 아래에 다음과 같은 패키지를 만든다
    - controller
    - dto
    - component
3) controller 패키지에 BoardController를 작성한다.

브라우저를 연다.
### SpringBoot + Thymeleaf 
- http://localhost:8080/boards
- http://localhost:8080/boards?{id} 
- 서버의 잘못은 500번대 에러
----

- URL 설계
- 게시판 목록보기
    - path : /board/{gameId}/{boardId}
    - 파라미터 : sort = PID | name
    - p = 1 <= x < n, 없을경우 1이 기본값
    - 로직 : p에 해당하는 게시물 목록을 읽어온다.
        - 전체 게시물 수를 구한다.
    - 프로토타이핑


### Spring MVC 구성요소와 동작
- '/'(모든경로)를 처리해주는 DefaultServlet
- DispatcherServlet : 모든 경로를 받아서 처리를 해준다.
- 컨트롤러가 100개면 그 정보를다(메소드포함) 읽어서 HandlerMapping에 저장을 한 뒤 관리한다.
- HandlerAdapter를 이용해서 Controller 메소드를 실행한다.
- ViewName > ViewResolver > View


### WebMVC
- WebMvcConfigurerAdapter가 Deprecated 됨
- Spring 5는 JdK 8이상에서만 동작.
- Spring Boot 2 는 Spring 5를 사용

### Thread Local
- `Thread Local` - 같은 스레드 상이면 언제든 가져다 쓸 수 있다.
    - RequestContextHolder 언제 사용될지 모르는
    
### forward, redirect
- 요청(`/boards`) > Controller 메소드 실행 > viewName 리턴 > xxx.html 
- forward : 사용자가 요청한 객체를 view.html까지 전달, forward 동안은 값이 유지된다.(request scope)
    - HttpServletRequest
        - setAttribute
        - getAttribute
- redirect : 완전히 새로운 페이지로 이동한다. 
    - flashMap : redirect로 값을 전달할때, get방식으로 파라미터 값을 전달 하던지 flashMap 사용가능    
- HttpServletRequest에는 파일 업로드 기능을 제공하지 않음.
    - 스프링에서는 HttpServletRequest를 래핑해서 해당 기능을 추가해서 제공해준다.
    
### Dispatcher Servlet <-> Controller 사이의 Interceptor
- DispatcherServlet과 Controller 사이에서 값을 주고받을때 중간에서 값을 체크할 수 있는 Interceptor가 있다.
- Interceptor는 Spring MVC 기술
- HandlerExecutionChain 어떤 인터셉터가 실행되고 어떤 컨트롤러가 실행될지 알고 있는 객체
    - 있으면 HandlerAdapter 결정
    - 없으면 Exception
    
### JRebel
- 핫 리로딩


    
 

