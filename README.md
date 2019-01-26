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

# [3 주차]

- @RequestParam
    - 파라미터를 각각 하나씩 받을 수 있다.
    - 하지만 여러데이터를 받을 경우 해당 어노테이션이 남발됨.
    - 따라서 나온게 @ModelAttribute
- @ModelAttribute
    - 모델 데이터를 한번에 받을 수 있음.
    - 특정 어노테이션을 붙혀서 사용자가 원하는 메세지를 보내지 않을시, 오류 메세지를 노출 할 수 있음.
- 문자열을 객체로 바꿔준다. (MessageConverter)

### Controller가 리턴하는것
- View name
- Component name
- Data 객체

### ObjectMapper
- 객체 > Json
- Json > 객체

### Bean들이 잘 생성되었나 확인해보려면

```java
@Autowired
HttpMessageConverters httpMessageConverters;
    
@Override
public void run(String... args) throws Exception {
    httpMessageConverters.getConverters().forEach(
            System.out::println
    );
}
```

### DBMS
- MySQL은 DBMS이다.
    1. DB 생성
    2. 계정생성
    3. 권한부여
- 사용시
    - IP PORT
    - Password
    - 사용할 DB
    - SQL
        - DDL
        - DML
        
- SQL를 모르면 JPA도 잘 할줄 모른다. SQL은 기본이 되어야 한다.
- DB 연결을 위해서 HikariCP라는 것이 사용된다.

- 트랜젝션 : 몽땅 성공하던지, 몽땅 실패하던지
- 선언적 트랜젝션 : 선언만 해놓으면 자동으로 트랜젝션 처리를 해줌. (xml, annotation)
- select만 여러번 하면 commit, rollback이 필요없다. select하는 상태에서 commit을 하게 되면 오버헤드가 발생함.
    - 난 이안에서 select만 실행한다, 난 이 sql에서 insert, update가 이루어진다를 구분해줘야 함.
    
### Java에서는 어떻게 DB를 사용할까?
- java.sql
- 인터페이스
    - Connection(DB 연결), PreparedStatement(SQL 실행), ResultSet(SQL 결과)
- JDBC 공부는 위의 인터페이스 사용법만 알아도 된다.


DB 연결 : `Connection conn = DriverManager.getConnection(dbUrl, id, pw)`

- 데이터베이스 연결에 시간이 많이 걸렸다. 그래서 이걸 어떻게 해결할까 고민하다가 `Connection Pool`의 개념이 탄생
- `Connection Pool` : 미리 데이터베이스 연결을 해두겠다. 미리 커넥션을 여러개 연결해둠.
- Connection close 하면 사용자가 사용하던 커넥션이 자동으로 반납된다.
- 동시에 커넥션이 필요한 경우, 모든 커넥션이 사용되면 그 이후 커넥션할 사람은 `대기열`, `병목현상`이 발생.
- 느린 SQL이 3초걸린다. 하지만 하루에 2번정도밖에 호출되지 않는다. 이와 반대로 어떤 SQL은 0.2초인데 100만번 호출된다면, 이것이 튜닝대상.

### JPA
- 자바 개발자는 객체지향 프로그래밍을 하는데 SQL??
- JPA - 구현체 : 하이버네이트
- Spring 입장?
    - 저장소가 DBMS만 있는것은 아니더라... (NoSQL도 있더라 ... )
    - Spring Data 공통. - Spring Data JPA
- 사용하는 이유?
    - 생산성 증가
    - 유지보수
    - SQL 중심적인 개발 > 객체중심 개발
    - 표준
    - 데이터 접근 추상화와 벤더 독립성
        - DB마다 SQL문법이 다른데, SQL에 따라서 자동으로 맞게 변경해준다.
- 영속성
    - 휘발서의 반대. 유지되는 것
    - EntityManager라는 객체에 부탁을해서 이 인스턴스를 영속성을 부여해달라고 함.
    - EntityManager에서 객체가 테이블과 관계를 맺고 있다면 자동으로 Table에 Insert를 해준다.
    - 영속성을 판단하는 기준은 @Entity, @Table을 사용해서 알 수 있도록 하자.
    - 읽어오는 것도 마찬가지로 EntityManager에게 부탁함.
    - 영속성이 유지되려면 반드시 id 값이 부여 되어야함.


## [4 주차]

- JDBC > SQL Mappter (SQL중심 - Spring JDBC, MyBatis)
         ORM         (객체중심 - JPA(Java표준) - Spring Data JPA)
         
- ORM - 테이블과 맵핑하는 객체 (Entity) -> 자동으로 테이블이 생성가능.

1) Entity 클래스를 작성. Id(식별자)를 가져야 한다.
2) 1:1, 1:*, *:* 연관관계를 고민 - 비지니스 로직에 대한 고민
3) Repository를 작성 (JPQL, QueryDSL 등을 사용하여 조회를 어떻게 할까?)
4) Repository를 실행하면서 Test. 자동으로 생성되는 SQL을 잘 확인. 

- 연관관계가 Repository에서 JPQL을 사용할 때 Join조건으로 사용될 수 있다.
- 연관관계를 통해서 데이터를 읽어올 때 사용한다. (lazy)

```java
    // @OneToMany(mappedBy = "department")
    // mappedBy < 반대편 컬럼을 참조하겠다.
    // JoinColumn을 사용하면 왜래키가 생긴다. 1:N 이라고 하면 N쪽에 왜래키가 생긴다.
    @OneToMany
    @JoinColumn(name = "deptno")
    private Set<Employee> employees;
```

- JPA에서 복합키를 만드는 방법
    - 복합키를 만드는 방법은 키가 묶어 클래스를 만든다.
    - @EmbeddedId, @Embeddedable
```java
@Entity
@Table(name = "project_participation")
@Getter
@Setter
public class ProjectParticipation {
    @EmbeddedId
    private ProjectParticipationId projectParticipationId;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

@Data
@Embeddable
public class ProjectParticipationId   implements Serializable {
    private Integer projectno;
    private Integer empno;

    @Column(name = "start_date", length = 12)
    private String startDate;
}
```
    
- 엔티티만 만들었다고 엔티티를 이용할수 없다. Repository를 생성해야함.


