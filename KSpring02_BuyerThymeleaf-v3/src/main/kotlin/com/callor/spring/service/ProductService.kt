package com.callor.spring.service

import com.callor.spring.model.Sales
import org.springframework.stereotype.Service

@Service
interface ProductService {
    fun selectAll(): Array<Sales>
    fun findById(userid: String): Sales
    fun findByName(name: String): Array<Sales>
    fun findByTel(name: String): Array<Sales>

    fun insert(sales: Sales): Int
    fun delete(sales: Sales): Int
    fun update(sales: Sales): Int
}