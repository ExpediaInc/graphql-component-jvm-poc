package com.expedia.partner.graphql.graphqlserverdemo.handlers

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.lang.System.getenv

@Component
class KumoHandler {

    fun isActive(): Mono<ServerResponse> {
        return ServerResponse.ok().body(fromObject("ACTIVE"))
    }

    fun buildInfo(): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8).body(BodyInserters.fromObject(
                mapOf("version" to (getenv("ACTIVE_VERSION") ?: "dev"))))
    }
}
