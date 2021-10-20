package com.callor.spring.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * DTO(VO) 클래스
 */
@Entity
@Table(name = "tbl_buyer", schema = "naraDB")
data class Buyer(
    // 칼럼들을 멤버변수로 선언
    @Id
    @Column(columnDefinition = "CHAR(4)", nullable = false, unique = true, name = "userid")
    var userid: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    var name: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var tel: String,

    @Column(nullable = true)
    var address: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var manager: String,

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    var man_tel: String,

    @Column(columnDefinition = "CHAR(4)", nullable = true)
    var buy_total: Int? = 0
)