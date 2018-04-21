package br.com.zup.querydsl.querydsl.controller

import br.com.zup.querydsl.querydsl.domain.Customer
import br.com.zup.querydsl.querydsl.service.CustomerService
import com.querydsl.core.types.Predicate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/customers")
class CustomerController constructor(private val customerService: CustomerService) {


    @GetMapping("{id}")
    fun findOne(id: Long) = customerService.findOne(id)

    @GetMapping
    fun findByPredicate(pageable: Pageable?, predicate: Predicate?): Page<Customer> {
        return customerService.findByPredicate(pageable, predicate)
    }

}