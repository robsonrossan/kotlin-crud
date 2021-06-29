package com.br.kotlin.mercadolivro.controller

import com.br.kotlin.mercadolivro.controller.request.PostBookRequest
import com.br.kotlin.mercadolivro.controller.request.PutBookRequest
import com.br.kotlin.mercadolivro.model.BookModel
import com.br.kotlin.mercadolivro.service.BookService
import com.br.mercadolivro.extension.toBookModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (

    var bookService: BookService,
    val customerService: CustomController
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create (@RequestBody request: PostBookRequest){
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel>{
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> =
        bookService.findActives()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel{
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update (@PathVariable id: Int, @RequestBody book: PutBookRequest){
        val bookUpdated = bookService.findById(id)
        bookService.update(book.toBookModel(bookUpdated))

    }
}