package br.com.zup.querydsl.service.repository

import br.com.zup.querydsl.domain.Customer
import br.com.zup.querydsl.domain.CustomerId
import br.com.zup.querydsl.domain.QCustomer
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.dsl.StringPath
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QueryDslPredicateExecutor
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer
import org.springframework.data.querydsl.binding.QuerydslBindings
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, CustomerId>,
                               QueryDslPredicateExecutor<Customer>,
                               QuerydslBinderCustomizer<QCustomer> {

    @JvmDefault
    override fun customize(bindings: QuerydslBindings, qCustomer: QCustomer) {
        bindings.bind(String::class.java).all { path: StringPath, values ->
            BooleanBuilder().apply {
                values.forEach { this.or(path.containsIgnoreCase(it)) }
            }
        }

    }
    
    @Deprecated("no compile safe", replaceWith = ReplaceWith("this.findAll(predicate)"))
    @Query("select c from Customer c " +
                   "where UPPER(c.name) like UPPER('%'||?1||'%') " +
                   "  and c.gender=?2 ")
    fun findWithQuery(name: String, gender: Char, pageable: Pageable): Page<Customer>

}
