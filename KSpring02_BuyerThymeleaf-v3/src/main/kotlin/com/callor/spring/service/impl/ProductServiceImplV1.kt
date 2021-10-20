//package com.callor.spring.service.impl
//
//import com.callor.spring.model.Sales
//import com.callor.spring.service.ProductService
//import org.springframework.stereotype.Service
//import kotlin.random.Random
//
//@Service
//class ProductServiceImplV1 : ProductService {
//
//    private companion object {
//        val RND = Random(System.currentTimeMillis())
//        val Sales_LISTS = arrayOf(
//            Sales(
//
//                name = "아이폰 13",
//                p_price = "1,200,000",
//                p_qty = 10,
//                total_price = "12,000,000"
//            ),
//            Sales(
//                p_id = "P002",
//                p_no = 2,
//                p_name = "갤럭시 zFlip3",
//                p_price = "1,500,000",
//                p_qty = 10,
//                total_price = "15,000,000"
//            )
//        )
//    }
//
//    override fun selectAll(): Array<Sales> {
//        return Sales_LISTS
//    }
//
//    override fun findById(p_id: String): Sales {
//        val findUser = Sales_LISTS.filter { product -> product.p_id == p_id }
//        return findUser[0]
//    }
//
//    override fun findByName(name: String): Array<Sales> {
//        val userNum = RND.nextInt(Sales_LISTS.size)
//        return arrayOf(Sales_LISTS[userNum])
//    }
//
//    override fun findByTel(name: String): Array<Sales> {
//        TODO("Not yet implemented")
//    }
//
//    override fun insert(sales: Sales): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun delete(sales: Sales): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun update(sales: Sales): Int {
//        TODO("Not yet implemented")
//    }
//}