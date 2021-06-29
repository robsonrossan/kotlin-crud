package com.br.kotlin.mercadolivro.service

import com.br.kotlin.mercadolivro.model.CustomerModel
import com.br.kotlin.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository,
    val bookService: BookService
){

    fun getAll(name: String?): List<CustomerModel>{
        name?.let {
            return customerRepository.findByName(it)
        }
        return  customerRepository.findAll().toList()
     }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)){
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customerModel = findById(id)
        bookService.deleteByCustomer(customerModel)
        customerRepository.deleteById(id)



//        ISSO E UMA FORMA DE SE FAZER
//        if(!customerRepository.existsById(id)){
//            throw Exception()
//        }
//        customerRepository.deleteById(id)
    }
}