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

    override fun selectAll():Array<ReadBookDTO> {
        // logger().debug("ALL! rDao: {}", rDao.findAll())
        return rDao.findAll().toTypedArray()
    }

    override fun readBookInsert(readBook: ReadBookVO) {

        val readBookDTO = ReadBookDTO(
            0,
            isbn = readBook.isbn,
            title = readBook.title,
            sdate = readBook.sdate,
            stime = readBook.stime,
            edate = readBook.edate,
            etime = readBook.etime,
            subject = readBook.subject,
            content = readBook.content,
        )
        val bookDTO = BookDTO(isbn = readBook.isbn, title = readBook.title)

        rDao.save(readBookDTO)
        bDao.save(bookDTO)

    }
}