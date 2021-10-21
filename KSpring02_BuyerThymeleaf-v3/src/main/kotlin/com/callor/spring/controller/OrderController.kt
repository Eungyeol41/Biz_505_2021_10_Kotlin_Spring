package com.callor.spring.controller

import com.callor.spring.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value = ["/order"])
class OrderController {

    @Autowired
    private lateinit var pService: ProductService

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun list(model:Model):String {

        var proInfo = pService.selectAll()
        model["PRODUCT"] = proInfo

        return "order/list"
    }
}