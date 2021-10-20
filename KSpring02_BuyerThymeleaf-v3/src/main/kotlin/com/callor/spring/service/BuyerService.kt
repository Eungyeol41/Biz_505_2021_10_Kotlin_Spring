package com.callor.spring.service

import com.callor.spring.model.Buyer

interface BuyerService {

    fun selectAll(): Array<Buyer>
    fun findById(userid: String): Buyer
    fun findByName(name: String): Array<Buyer>
    fun findByTel(name: String): Array<Buyer>

    fun insert(buyer: Buyer): Buyer
    fun delete(buyer: Buyer): Buyer
    fun update(buyer: Buyer): Buyer
}