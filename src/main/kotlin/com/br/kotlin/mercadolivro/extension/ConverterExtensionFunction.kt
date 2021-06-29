package com.br.mercadolivro.extension

import com.br.kotlin.mercadolivro.controller.request.PostBookRequest
import com.br.kotlin.mercadolivro.controller.request.PutBookRequest
import com.br.kotlin.mercadolivro.enum.BookStatusEnum
import com.br.kotlin.mercadolivro.model.BookModel
import com.br.kotlin.mercadolivro.model.CustomerModel
import com.br.mercadolivro.controller.request.PostCustomerRequest
import com.br.mercadolivro.controller.request.PutCostumerRequest


fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCostumerRequest.toCustomerModel(id: Int): CustomerModel{
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel{
    return BookModel(
        name = this.name,
        price = this.price,
        status =  BookStatusEnum.ATIVO,
        customerModel = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel{
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name, //isso ?: se chama elvis operation...caso name ser nulo o Kotlin seta o valor antigo
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customerModel = previousValue.customerModel
    )
}

