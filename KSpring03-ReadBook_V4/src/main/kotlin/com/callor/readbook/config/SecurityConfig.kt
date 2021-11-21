package com.callor.readbook.config

import com.callor.readbook.service.MemberLoginService
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@EnableWebSecurity
@SpringBootConfiguration
class SecurityConfig:WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/static/**",
                "/static/css/**",
                "/static/js/**",
                "/static/images/**",
                "*.ico",
                "*.txt"
        )
        web.ignoring().requestMatchers(
                PathRequest.toStaticResources().atCommonLocations()
        )
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/member/mypage").authenticated()
            .antMatchers("/**").permitAll()

        // 추가
        // html의 token 때문에 input과 login이 한 번씩 나오지 않는 오류가 있었다.
        /**
         * Spring Security의 정책으로 POST Token 설정이 https에만 적용되도록 하였다.
         *
         * 아래 옵션을 포함하여 http에서도 적용되도록 설정
         * 단, 개발 과정에서만 사용하고 실제 https 적용 서버에 배포할 때는 옵션을 제거하는 것이 좋다.
         */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

        http.formLogin()
                .loginPage("/member/login").permitAll()
                .loginProcessingUrl("/login")
                .successForwardUrl("/member/mypage")

        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/member/mypage")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(MemberLoginService())
                .passwordEncoder(CustomPasswordEncoder())
    }
}

class CustomPasswordEncoder:PasswordEncoder {
    override fun encode(plan: CharSequence): String {
        return plan.toString()
    }

    override fun matches(plan: CharSequence?, crypt: String?): Boolean {
        return plan == crypt
    }
}