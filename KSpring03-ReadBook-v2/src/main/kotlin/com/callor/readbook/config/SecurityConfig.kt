package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig:WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        // HttpSecurity를 통해서 오는 모든 요청을 가로채기 할 것이다!!

        http.authorizeRequests()
            // url에 member/mypage로 요청이 들어오면
            .antMatchers("/member/mypage")
            // 인증을 받아라!!
            .authenticated()
            // mvcMatchers()에 비하여 정교하게 관리한다.
            // 그 외의 모든 요청은 통과시켜라
            .antMatchers("/**").permitAll()
            // /**는 모든 요청을 의미함
             .mvcMatchers("/**")
            // anonymous() -- 누구나
            .anonymous()
            // admin으로 접속을 하면
            // .mvcMatchers("/admin")
            // 인증을 받아야 한다
            // .fullyAuthenticated()
//            .and()
//            .httpBasic()

        // http.httpBasic()
        
        // 만약 인증이 필요한 페이지에 권한이 없이 접근하면 `/member/login`으로 redirect 하라
        http.formLogin().loginPage("/member/login").permitAll()
    }
}