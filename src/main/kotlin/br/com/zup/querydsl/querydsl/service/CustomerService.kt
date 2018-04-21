package br.com.zup.querydsl.querydsl.service

import br.com.zup.querydsl.querydsl.domain.Customer
import br.com.zup.querydsl.querydsl.repository.CustomerRepository
import com.querydsl.core.types.Predicate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

interface CustomerService {
    fun findAll(pageable: Pageable): Page<Customer>
    fun findOne(id: Long): Customer
    fun findByPredicate(pageable: Pageable?, predicate: Predicate?): Page<Customer>
}

@Service
class CustomerServiceImpl constructor(private val repository: CustomerRepository) : CustomerService {

    override fun findAll(pageable: Pageable): Page<Customer> = this.repository.findAll(pageable)

    override fun findOne(id: Long): Customer = this.repository.findOne(id)

    override fun findByPredicate(pageable: Pageable?, predicate: Predicate?): Page<Customer> =
            repository.findAll(predicate, pageable)
}
