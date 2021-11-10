package com.callor.readbook.controller

import com.callor.readbook.config.logger
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.service.impl.ReadBookServiceImplV1
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController {

    @Autowired
    lateinit var readBookService: ReadBookServiceImplV1

    @RequestMapping(value = ["", "/"], method = [RequestMethod.GET])
    fun home(): String {
        return "redirect:/list"
    }


    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(model: Model): String {
        var rbList = readBookService.selectAll()
        logger().debug("rbList: {}", rbList)
        model["LIST"] = rbList

        return "readBook/list"
    }


    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(): String {
        return "readBook/write"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO): String {
        logger().debug(
            """>
            수신한 데이터
                {}""", readBook.toString()
        )

        readBookService.readBookInsert(readBook)

        return "redirect:/list"
    }
}
