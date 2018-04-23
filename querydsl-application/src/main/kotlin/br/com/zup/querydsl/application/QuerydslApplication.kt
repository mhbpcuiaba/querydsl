package br.com.zup.querydsl.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("br.com.zup.querydsl")
@EnableJpaRepositories("br.com.zup.querydsl.service.repository")
@EntityScan("br.com.zup.querydsl.domain")
class QuerydslApplication

fun main(args: Array<String>) {
    SpringApplication.run(QuerydslApplication::class.java, *args)
}











