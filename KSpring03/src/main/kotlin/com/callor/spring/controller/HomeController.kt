package com.callor.spring.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @ResponseBody
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun home(): String {
        return "우리나라만세"
    }

    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(): String {
        return "home";
    }
}