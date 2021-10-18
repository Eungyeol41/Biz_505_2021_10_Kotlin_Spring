package com.callor.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * web.xml 파일을 대신하는 boot class 만들기
 */
@SpringBootApplication
class KSpring02Application

fun main(args: Array<String>) {

	// application 작동
	runApplication<KSpring02Application>(*args)
}
