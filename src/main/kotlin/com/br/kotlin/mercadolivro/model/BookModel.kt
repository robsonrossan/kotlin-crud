package com.br.kotlin.mercadolivro.model

import java.math.BigDecimal
import javax.persistence.*
import com.br.kotlin.mercadolivro.enum.BookStatusEnum

@Entity(name = "book")
data class BookModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatusEnum,

    @ManyToOne
    @JoinColumn(name = "customer_id") //id tabela book que faz foreingKey com a tabela Customer
    var customerModel: CustomerModel? = null

    )


