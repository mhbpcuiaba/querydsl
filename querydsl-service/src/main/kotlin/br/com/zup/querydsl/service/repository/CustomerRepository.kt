package br.com.zup.querydsl.service.repository

import br.com.zup.querydsl.domain.Customer
import br.com.zup.querydsl.domain.QCustomer
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.dsl.StringPath
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor
import org.springframework.data.querydsl.binding.MultiValueBinding
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer
import org.springframework.data.querydsl.binding.QuerydslBindings
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long>,
                               QueryDslPredicateExecutor<Customer>,
                               QuerydslBinderCustomizer<QCustomer> {

    @JvmDefault
    override fun customize(bindings: QuerydslBindings, qCustomer: QCustomer) {

        bindings.bind(String::class.java).all { path:StringPath, values ->
            BooleanBuilder().apply {
                values.forEach { this.or(path.containsIgnoreCase(it)) }
            }
        }

        bindings.bind(QCustomer.customer.gender).first { path, gender
            -> path.eq(gender.toUpperCase()) }

    }

}
