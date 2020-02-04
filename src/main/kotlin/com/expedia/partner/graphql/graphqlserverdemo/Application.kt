package com.expedia.partner.graphql.graphqlserverdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val app = SpringApplication(Application::class.java).run(*args)
}

