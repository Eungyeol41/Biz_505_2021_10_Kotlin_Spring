package com.callor.readbook.service.impl

import com.callor.readbook.config.logger
import com.callor.readbook.model.BookDTO
import com.callor.readbook.model.ReadBookDTO
import com.callor.readbook.model.ReadBookVO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.repository.ReadBookRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Service

@Service("rServiceV1")
class ReadBookServiceImplV1(val rDao:ReadBookRepository, val bDao:BookRepository):ReadBookService {

    override fun selectAll() {
        rDao.findAll()
        logger().debug("ALL! rDao: {}", rDao.findAll())
    }

    override fun readBookInsert(readBook: ReadBookVO) {

        val readBookDTO = ReadBookDTO(0, isbn = readBook.isbn, title = readBook.title, content = readBook.content)
        val bookDTO = BookDTO(isbn = readBook.isbn, title = readBook.title)

        rDao.save(readBookDTO)
        bDao.save(bookDTO)

    }
}