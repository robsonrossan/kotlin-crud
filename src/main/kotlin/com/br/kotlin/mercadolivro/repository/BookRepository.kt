package com.br.kotlin.mercadolivro.repository

import com.br.kotlin.mercadolivro.enum.BookStatusEnum
import com.br.kotlin.mercadolivro.model.BookModel
import com.br.kotlin.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int>{

    fun findByStatus(status: BookStatusEnum): List<BookModel>
    //fun findByCustomer(customerModel: CustomerModel): List<BookModel>
}