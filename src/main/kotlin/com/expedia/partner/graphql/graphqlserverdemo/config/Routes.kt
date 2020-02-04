package com.expedia.partner.graphql.graphqlserverdemo.config

import com.expedia.partner.graphql.graphqlserverdemo.handlers.KumoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Suppress("ParameterListWrapping")
@Configuration
class Routes
(
        private val handler: KumoHandler
) {

    @Bean
    fun isActive() = router {
        GET("/isActive") { handler.isActive() }
    }

    @Bean
    fun buildInfo() = router {
        GET("/buildInfo") { handler.buildInfo() }
    }
}
