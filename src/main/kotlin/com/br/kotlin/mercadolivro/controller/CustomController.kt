package com.br.kotlin.mercadolivro.controller

import com.br.kotlin.mercadolivro.model.CustomerModel
import com.br.kotlin.mercadolivro.service.CustomerService
import com.br.mercadolivro.controller.request.PostCustomerRequest
import com.br.mercadolivro.controller.request.PutCostumerRequest
import com.br.mercadolivro.extension.toCustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomController (
        val customerService : CustomerService
){

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody costumer: PostCustomerRequest) {
        customerService.create(costumer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): CustomerModel {
        return customerService.findById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id : Int, @RequestBody customer: PutCostumerRequest) {
        customerService.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}