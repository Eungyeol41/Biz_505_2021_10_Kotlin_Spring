package com.callor.readbook.controller

import com.callor.readbook.model.MemberVO
import com.callor.readbook.service.MemberLoginService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value = ["/member"])
class MemberController(val member:MemberLoginService) {

    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    fun login():String {
        return "member/login"
    }

    @RequestMapping(value = ["/mypage"], method = [RequestMethod.GET])
    fun mypage(@AuthenticationPrincipal userAccount:UserDetails, model:Model):String {
        val username = userAccount.username

        model["USER"] = member.findById(username)
        return "member/mypage"
    }

    @RequestMapping(value = ["/join"], method = [RequestMethod.GET])
    fun join():String {
        return "member/join"
    }

    @RequestMapping(value = ["/join"], method = [RequestMethod.POST])
    fun join(model:Model):String {
        return "redirect:/member/login"
    }

}

