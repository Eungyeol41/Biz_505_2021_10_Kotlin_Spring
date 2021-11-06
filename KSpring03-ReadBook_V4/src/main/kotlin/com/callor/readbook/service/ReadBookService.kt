package com.callor.readbook.service

import com.callor.readbook.model.ReadBookVO

interface ReadBookService {
    fun readBookInsert(readBook: ReadBookVO)
}