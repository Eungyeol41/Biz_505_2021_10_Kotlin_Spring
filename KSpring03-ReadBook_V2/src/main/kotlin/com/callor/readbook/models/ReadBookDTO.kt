package com.callor.readbook.models

import javax.persistence.*

@Entity
@Table(name = "tbl_readbooks")
data class ReadBookDTO(

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq: Long? = null,

    @Column(columnDefinition = "VARCHAR(13)", nullable = false)
    var isbn: String? = null,

    var title: String? = null,
    var sdate: String? = null,
    var stime: String? = null,
    var etime: String? = null,
    var subject: String? = null,
    var content: String? = null,

    )
