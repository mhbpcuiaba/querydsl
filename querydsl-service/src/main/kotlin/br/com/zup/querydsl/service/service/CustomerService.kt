package br.com.zup.querydsl.service.service

import br.com.zup.querydsl.domain.Customer
import br.com.zup.querydsl.service.repository.CustomerRepository
import br.com.zup.querydsl.service.service.representation.CustomerRepresentation
import com.querydsl.core.types.Predicate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

interface CustomerService {
    fun findAll(pageable: Pageable): Page<CustomerRepresentation>
    fun findOne(id: Long): CustomerRepresentation
    fun findByPredicate(predicate: Predicate?, pageable: Pageable?): Page<CustomerRepresentation>
}

@Service
class CustomerServiceImpl constructor(private val repository: CustomerRepository) : CustomerService {

    override fun findAll(pageable: Pageable): Page<CustomerRepresentation> =
            this.repository.findAll(pageable)
                    .map (::toRepresentation )

    override fun findOne(id: Long): CustomerRepresentation =
            this.repository.findOne(id)
                    .let (::toRepresentation )

    override fun findByPredicate(predicate: Predicate?, pageable: Pageable?): Page<CustomerRepresentation> =
            this.repository.findAll(predicate, pageable)
                    .map (::toRepresentation )


    private fun toRepresentation(customer: Customer) = CustomerRepresentation(customer.id, customer.name)
}
