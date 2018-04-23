package br.com.zup.querydsl.domain

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id


typealias CustomerId = Long
typealias CustomerName = String

enum class Gender { M, F; }

@Entity
data class Customer(@field:Id val id: CustomerId,
                    val name: CustomerName,
                    @field:Enumerated(EnumType.STRING) val gender: Gender)
