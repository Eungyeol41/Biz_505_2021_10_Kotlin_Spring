package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping(value = ["/buyer"])
class BuyerController(val bService: BuyerService) {

    // @GetMapping(name = ["/list"])
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(model: Model): String {

        val buyerList = bService.selectAll()
        model["BUYERS"] = buyerList

        return "buyer/list"
    }

    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("userid") userid: String): String {
        var userInfo = bService.findById(userid)
        model["BUYER"] = userInfo
//        println(userInfo.toString())

//        var proInfo = pService.selectAll()
//        model["PRODUCT"] = proInfo

        return "buyer/detail"
    }

//    @ResponseBody
//    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
//    fun insert(): Buyer {
//
//        val insertBuyer = ConfigData.BUYER_LIST[0]
//        bService.insert(insertBuyer)
//
//        return insertBuyer
//    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun write():String {
        return "buyer/write"
    }


    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(buyer:Buyer):String {
        bService.insert(buyer)

        return "redirect:/"

    }
}