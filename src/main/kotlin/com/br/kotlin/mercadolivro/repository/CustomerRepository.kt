package com.br.kotlin.mercadolivro.repository

import com.br.kotlin.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int>{

    fun findByName(name: String): List<CustomerModel>
}