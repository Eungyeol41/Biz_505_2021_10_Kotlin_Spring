package com.callor.readbook.service

import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO

interface ReadBookService {

    fun selectAll()
    fun readBookInsert(readBook: ReadBookVO)

}