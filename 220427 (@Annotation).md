## TIL : 22.04.27 (@Annotation)

### Spring

#### @Annotation 정리

1. **@Component**

- 하위 자식 3개

2. **@Controller, @Service, @Repository**

3. **@Configuration**
   - 빈 클래스 설정파일


4. **@ComponentScan**
   - 사용예시 : ComponentScan(basePackages = {"com.ssafy"})


5. **@Bean**
6. **@Autowired**
   - 생성자 주입, 필드 주입, 설정자 주입

7. **@Qualifier**
   - 사용예시 : @Qualifier(value="bookDaoImpl") : 특정하게 연결 시킬 때

8. **@RequestMapping** : 요청 url을 매칭시킬 때

   - 사용 예시
     1. @RequestMapping("/members/*.do")
     2. @RequestMapping("/bookapi**.do" method=Request.GET)
     3. @RequestMapping(/book/{isbn})

   - ' * ' : 한 글자 이상의 문자열과 매칭

​		9-1. **@GetMapping**("/book/{isbn}")
​		9-2. **@PostMapping**("/book")

10. **@PutMapping**({"/book", "/"})
11. **@DeleteMapping**("/book/{isbn}")
12. **@RequestParam** : 변수 이름에 맞춰 들어간다.

- 사용예시 : @RequestParam("articleno") int articleNo

13. **@ModelAttribute** : 요청에서 무언가를 담아서 보낼때 Dto에 담아서 보낼 때 사용, **받고 받은걸 다시 다른 것에 보낼때 사용**. 직접 보내달라고 하지 않아도 넘어감, <u>사용할 객체가 빈 객체로 선언되어야만 사용 가능하다. 아닐경우 @Requestparam만 가능한다.</u>
14. **@Model**, **@ModelAndView**
15. **@CookieValue**
16. **@RequestHeader**

#### AOP 관련 어노테이션

17. **@Aspect** : aop 설정 파일

18. **@Before**

19. **@AfterReturning**

20. **@AfterThrowing**

21. **@After**

22. **@Around**

    

23. **@Transactional** : 이전 커밋 시점에서 어노테이션이 선언된 메서드가 잘 수행되지 않았을 경우 Rollback

24. **@ResponseBody** : 내가 다음 페이지에 전달하고 싶은 데이터가 있을 때, 이것은 페이지가 아니고 데이터다 알리고 싶을 때

25. **@RestController** : 매번 ResponseBody를 선언하지 않고 한 번에 적용 시

26. **@CrossOrigin("*")** : 허용하고 싶은 URL만 적음

27. **@RequestBody** : 사용자의 요청이 JSON인 경우 알아서 맞춰서 넣어달라.

Swagger
27. **@EnableSwagger2** : 스웨거 2버전 사용하겠다.
27. **@Api**("어드민 컨트롤러 API V1")
29. **@ApiOperation**(value="회원목록", notes="회원의 <big>전체목록</big>을 반환해 줍니다.")
30. **@ApiResponses**({
        @ApiResponse(code=200, message="회원목록 OK"),
        @ApiResponse(code=404, message="페이지없어"),
        @ApiResponse(code=500, message="서버에러")
    })

31. **@ApiModel(**value = "MemberDto : 회원정보", description = "회원의 아이디, 이름, 비번, 가입일등을 설정")
    public class MemberDto {
        **@ApiModelProperty**(value = "회원 아이디")
        private String userid;
32. **@SpringBootApplication** : 하위 3개의 어노테이션 역할을 함
33. **@SpringBootConfiguration** : 
34. **@EnableAutoConfiguration**
35. **@ComponentScan**