package com.callor.readbook.service

import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO

interface ReadBookService {

    fun selectAll():Array<ReadBookDTO>
    fun readBookInsert(readBook: ReadBookVO)

}