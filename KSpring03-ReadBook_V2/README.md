# Spring Boot Security Project
* Dependency 설정

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
            <version>2.5.5</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity5 -->
        <!-- security를 사용할 수 있게 해주는 dependency -->
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity5</artifactId>
            <version>3.0.4.RELEASE</version>
        </dependency>

* Spring Framework에 Security 관련 Dependency를 설정하면 Project가
* Security에 wrapping 되어 모든 제어가 Security를 거쳐서 작동된다.
* Security 관련 Config를 설정하여 security 작동을 Custom화 하여 Project를 진행하게 된다.

## Spring Security에서 POST 전송
* Security Project에서는 절대 일반적인 방법으로 POST로 데이터를 보낼 수 없다
* thymeleaf의 extra-security의 도움을 받아 form을 재설정해야 한다.
* Security에서 POST로 데이터를 서버로 전송하려면 반드시 _csrf 변수에 Token을 담아서 같이 보내야 한다.
* thymeleaf에서 form tag에 th:action={}을 지정하면 자동으로 해당 변수가 form에 `<input type="hidden" />`으로 설정되어 준비된다

## CSRF: Cross-site Request Forgery
* 사이트 간 요청 위조
* 상대방 서버의 input form 화면의 코드를 복제하여 로컬에 파일로 만들고 일부 내용을 위조하여 다시 submit하여 서버로 전송하는 해킹 행위
* Spring Security는 POST로 전송되는 모든 데이터에 대하여 SCRF 거부 정책을 수행한다
* POST로 전송되는 모든 데이터에 _csrf 데이터가 없으면 거부한다 - (403 Forbidden 오류 발생)
* thymeleaf의 extra-security를 dependency에 설정해두면 thymeleaf에서 _csrf 값을 취급할 수 있다.