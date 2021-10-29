package com.callor.readbook.controller

import com.callor.readbook.config.logger
import com.callor.readbook.models.ReadBook
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController {

    @RequestMapping(value = ["", "/"], method = [RequestMethod.GET])
    fun home():String {

        return "redirect:/insert"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert():String {

        // return "readBook/write"
        return "readBook/write.html"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook: ReadBook):String {
        // logger().debug("수신한 데이터: {}", readBook).toString()
        logger().debug(""">
            수신한 데이터
                {}""", readBook.toString())

        return "redirect:/insert"
    }

}