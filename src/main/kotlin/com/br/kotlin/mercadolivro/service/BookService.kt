package com.br.kotlin.mercadolivro.service

import com.br.kotlin.mercadolivro.enum.BookStatusEnum
import com.br.kotlin.mercadolivro.model.BookModel
import com.br.kotlin.mercadolivro.model.CustomerModel
import com.br.kotlin.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService (
    val bookRepository: BookRepository
){

    fun create(bookModel: BookModel) {
        bookRepository.save(bookModel)
    }

    fun findAll(): List<BookModel> {
       return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatusEnum.ATIVO)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        var book = findById(id)
        book.status = BookStatusEnum.CANCELADO
        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customerModel: CustomerModel) {

    }
}
