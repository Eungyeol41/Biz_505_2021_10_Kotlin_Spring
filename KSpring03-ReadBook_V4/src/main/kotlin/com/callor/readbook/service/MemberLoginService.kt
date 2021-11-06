package com.callor.readbook.service

import com.callor.readbook.model.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MemberLoginService:UserDetailsService {

    private val userList = listOf(
            MemberVO(username = "in", password = "12345"),
            MemberVO(username = "iniz", password = "12345"),
            MemberVO(username = "inizz", password = "12345"),
    )

    override fun loadUserByUsername(username: String): UserDetails {
        val member:UserDetails? = userList.find { it.username == username }
        member ?: throw UsernameNotFoundException("사용자 ID가 잘못되었습니다.")

        return member
    }
}