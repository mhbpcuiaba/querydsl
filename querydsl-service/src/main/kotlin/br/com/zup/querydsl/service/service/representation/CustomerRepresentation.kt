package br.com.zup.querydsl.service.service.representation

import br.com.zup.querydsl.domain.CustomerId
import br.com.zup.querydsl.domain.CustomerName
import br.com.zup.querydsl.domain.Gender

data class CustomerRepresentation(val id: CustomerId, val name: CustomerName, val gender: Gender)
