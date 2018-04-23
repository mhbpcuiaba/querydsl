package br.com.zup.querydsl.application.controller

import br.com.zup.querydsl.domain.Customer
import br.com.zup.querydsl.service.service.CustomerService
import br.com.zup.querydsl.service.service.representation.CustomerRepresentation
import com.querydsl.core.types.Predicate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.querydsl.binding.QuerydslPredicate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/customers")
class CustomerController constructor(private val customerService: CustomerService) {


    @GetMapping("{id}")
    fun findOne(id: Long) = customerService.findOne(id)

    @GetMapping
    fun findByPredicate(@QuerydslPredicate(root = Customer::class) predicate: Predicate?,
                        pageable: Pageable?): Page<CustomerRepresentation> =
            customerService.findByPredicate(predicate, pageable)

}