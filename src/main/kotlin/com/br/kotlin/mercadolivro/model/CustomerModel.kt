package com.br.kotlin.mercadolivro.model

import com.br.kotlin.mercadolivro.enum.BookStatusEnum
import javax.persistence.*


@Entity(name = "customer")
data class CustomerModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatusEnum? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customerModel: CustomerModel? = null
    )


