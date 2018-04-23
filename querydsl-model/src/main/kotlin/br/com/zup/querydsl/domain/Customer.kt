package br.com.zup.querydsl.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Customer constructor(
        @field:Id var id: Long,
        @field:Column var name: String,
        @field:Column var gender: Char)