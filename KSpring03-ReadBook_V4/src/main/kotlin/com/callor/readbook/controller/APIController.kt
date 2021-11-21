package com.callor.readbook.controller

import com.callor.readbook.model.JusoVO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping(value = ["/api"])
class APIController {

    @RequestMapping(value = ["/input"], method = [RequestMethod.GET])
    fun input(): String? {
        return "juso_popup"
    }

    @RequestMapping(value = ["/popup"], method = [RequestMethod.GET])
    fun popup(model: Model): String? {
        // model.addAttribute("POPUP_KEY", AddressSecret.POPUP_ConfmKey)
        model.addAttribute("POPUP_KEY", "")
        return "api/juso_popup"
    }

    @RequestMapping(value = ["/popup"], method = [RequestMethod.POST])
    fun recv(jusoVO: JusoVO, model: Model): String? {
        // log.debug("수신된 데이터 {}", jusoVO.toString())
        model.addAttribute("JUSO", jusoVO)
        return "api/juso_popup"
    }
}