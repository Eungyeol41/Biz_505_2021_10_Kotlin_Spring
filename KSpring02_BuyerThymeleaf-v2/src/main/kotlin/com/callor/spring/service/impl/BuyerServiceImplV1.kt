package com.callor.spring.service.impl

import com.callor.spring.model.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service("bServiceV1")
class BuyerServiceImplV1 : BuyerService {

    // 현재 BuyerServiceImplV1에서 사용할 가상 데이터를 선언하기
    // private: 여기 class 내부에서만 사용하는 static 변수 선언하기
    private companion object {
        val RND = Random(System.currentTimeMillis())
        val BUYER_LIST = arrayOf(
            Buyer(
                userid = "B001",
                name = "Hong",
                address = "Seoul",
                tel = "010-1234-5786",
                manager = "Lee",
                man_tel = "010-111-2222",
                buy_total = 10000
            ),
            Buyer(
                userid = "B002",
                name = "Na",
                address = "Namwon",
                tel = "019-124-5996",
                manager = "Wolmae",
                man_tel = "010-2222-6568",
                buy_total = 15000
            ),
            Buyer(
                userid = "B003",
                name = "Jang",
                address = "Haenam",
                tel = "019-126-5776",
                manager = "Sinla",
                man_tel = "010-7878-1111",
                buy_total = 20000
            )
        )
    }

    override fun selectAll(): Array<Buyer> {
        return BUYER_LIST
    }

    override fun findById(userid: String): Buyer {
        val findUser = BUYER_LIST.filter { buyer -> buyer.userid == userid }
        return findUser[0]
    }

    override fun findByName(name: String): Array<Buyer> {
        val userNum = RND.nextInt(BUYER_LIST.size)
        return arrayOf(BUYER_LIST[userNum])
    }

    override fun findByTel(name: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun insert(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

    override fun delete(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

    override fun update(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

}