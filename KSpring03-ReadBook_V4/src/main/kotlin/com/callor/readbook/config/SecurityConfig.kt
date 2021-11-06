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
                // "*.icon", (icon이 아닌가...?)
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

        http.formLogin()
                .loginPage("/member/login").permitAll()
                .loginProcessingUrl("/login")

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