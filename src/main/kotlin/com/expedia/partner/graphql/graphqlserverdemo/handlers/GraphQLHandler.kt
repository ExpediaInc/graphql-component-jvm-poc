package com.expedia.partner.graphql.graphqlserverdemo.handlers


import com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.PartnerInquiryComponent
import graphql.schema.GraphQLSchema
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class GraphQLHandler(val component: PartnerInquiryComponent) {

    @Bean
    fun schema() : GraphQLSchema {
       return component.schema()
    }
}