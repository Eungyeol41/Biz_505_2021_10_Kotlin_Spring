package com.callor.readbook.service

import com.callor.readbook.model.MemberVO
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MemberLoginService():UserDetailsService {

    private val userList = listOf(
            MemberVO(username = "in", password = "12345", email="iniziato@naver.com", tel = "010-1234-5678", address = "Gwang-Ju"),
            MemberVO(username = "iniz", password = "12345", email = "iniziato@daum.net", tel = "010-9532-1375", address = "Busan"),
            MemberVO(username = "inizz", password = "12345", email = "iniziato@go.kr", tel = "010-1213-3333", address = "Seoul"),
    )

    override fun loadUserByUsername(username: String): UserDetails {
        val member:UserDetails? = userList.find { it.username == username }
        member ?: throw UsernameNotFoundException("사용자 ID가 잘못되었습니다.")

        return member
    }

    fun findById(username: String):MemberVO{
        val member = userList.filter { it.username == username }

        return member.get(0)
    }

}

