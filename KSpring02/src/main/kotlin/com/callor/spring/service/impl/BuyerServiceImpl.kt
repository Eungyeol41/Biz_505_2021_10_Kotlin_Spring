package com.callor.spring.service.impl

import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class BuyerServiceImpl : BuyerService {

    /**
     * Kotlin 클래스 내에서 선언되며
     * 클래스가 작동되는 데 필요한 필수 데이터나 어떤 옵션을 초기화하는 초기화 블럭 객체
     */
    companion object {

        val rnd = Random(System.currentTimeMillis())

        // Map 데이터 생성하기
        // val user = Pair("name", "Hong")
        // val id = Pair("id", "user")
        // val age = Pair("age", 22)

        /**
         * Buyer DTO를 사용하여 3명의 데이터를 선언하고 List 배열로 생성
         */
        val userList = arrayOf(
            Buyer(id = "admin", name = "Hong", age = 22),
            Buyer(id = "user", name = "Lee", age = 24),
            Buyer(id = "guest", name = "Na", age = 26),
        )
    }

    override fun selectAll(): Array<Buyer> {
        return userList
    }

    override fun findById(id: String): Buyer {
        val num = rnd.nextInt(userList.size)
        return userList[num]

    }
}