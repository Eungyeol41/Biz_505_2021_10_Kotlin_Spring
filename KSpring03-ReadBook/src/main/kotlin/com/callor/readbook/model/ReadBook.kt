package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_readbook", schema = "naraDB")
data class ReadBook(
    @Id
    @Column(columnDefinition = "BIGINT", unique = true, name = "seq")
    var seq: Long? = null,

    @Column(columnDefinition = "VARCHAR(13)", nullable = false)
    var isbn: String? = null,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var rdate: String? = null,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var stime: String? = null,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var etime: String? = null,

    @Column(nullable = false)
    var rating: Int? = null,

    @Column(nullable = false)
    var comment: String? = null,
)