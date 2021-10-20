package com.callor.spring.service.impl

import com.callor.spring.ConfigData
import com.callor.spring.model.Buyer
import com.callor.spring.repository.BuyerRepository
import com.callor.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

/**
 * 클래스의 매개변후를 사용하여 생성자 주입하기
 *
 * class 클래스( 주입받을 객체, 변수 선언 )
 */
@Service("bServiceV1")
class BuyerServiceImplV1(val bRepo: BuyerRepository) : BuyerService {

    // setter 주입으로 wiring하기
    @Autowired
    lateinit var bDao: BuyerRepository

    // 현재 BuyerServiceImplV1에서 사용할 가상 데이터를 선언하기
    // private: 여기 class 내부에서만 사용하는 static 변수 선언하기

    override fun selectAll(): Array<Buyer> {
        return ConfigData.BUYER_LIST
    }

    override fun findById(userid: String): Buyer {
        val findUser = ConfigData.BUYER_LIST.filter { buyer -> buyer.userid == userid }
        return findUser[0]
    }

    override fun findByName(name: String): Array<Buyer> {
        val userNum = ConfigData.RND.nextInt(ConfigData.BUYER_LIST.size)
        return arrayOf(ConfigData.BUYER_LIST[userNum])
    }

    override fun findByTel(name: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun insert(buyer: Buyer): Buyer {

        // INSERT OR UPDATE
        return bDao.save(buyer)
    }

    override fun delete(buyer: Buyer): Buyer {
        TODO("Not yet implemented")
    }

    override fun update(buyer: Buyer): Buyer {
        TODO("Not yet implemented")
    }

}