package com.callor.spring.service.impl

import com.callor.spring.model.Sales
import com.callor.spring.service.ProductService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ProductServiceImplV1 : ProductService {

    private companion object {
        val RND = Random(System.currentTimeMillis())
        val Sales_LISTS = arrayOf(
            Sales(
                seq= 1,
                p_id= "P001",
                date="2021-10-21",
                time="15:40",
                pname = "아이폰 13",
                amt = 1500000,
                qty = 10,
                total = 15000000
            ),
            Sales(
                seq= 2,
                p_id= "P002",
                date="2021-10-21",
                time="15:41",
                pname = "갤럭시 폴드",
                amt = 1200000,
                qty = 10,
                total = 12000000
            ),
        )
    }

    override fun selectAll(): Array<Sales> {
        return Sales_LISTS
    }

    override fun findById(p_id: String): Sales {
        val findUser = Sales_LISTS.filter { product -> product.p_id == p_id }
        return findUser[0]
    }

    override fun findByName(name: String): Array<Sales> {
        val userNum = RND.nextInt(Sales_LISTS.size)
        return arrayOf(Sales_LISTS[userNum])
    }

    override fun findByTel(name: String): Array<Sales> {
        TODO("Not yet implemented")
    }

    override fun insert(sales: Sales): Int {
        TODO("Not yet implemented")
    }

    override fun delete(sales: Sales): Int {
        TODO("Not yet implemented")
    }

    override fun update(sales: Sales): Int {
        TODO("Not yet implemented")
    }
}