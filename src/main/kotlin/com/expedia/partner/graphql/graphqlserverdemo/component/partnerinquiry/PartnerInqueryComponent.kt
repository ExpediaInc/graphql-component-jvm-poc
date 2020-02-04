package com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry

import com.coxautodev.graphql.tools.GraphQLResolver
import com.expedia.partner.graphql.graphqlserverdemo.api.GraphQLComponent
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.PartnerComponent
import com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.resolvers.PartnerInquiryQuery
import org.springframework.stereotype.Component

@Component
class PartnerInquiryComponent (partnerInquiryQuery: PartnerInquiryQuery, partnerComponent: PartnerComponent):
        GraphQLComponent(){
    override var types = arrayOf("partner-inquiry-types.graphqls", "partner-inquiry-component.graphqls")
    override var resolvers: Array<GraphQLResolver<*>> = arrayOf(partnerInquiryQuery)
    override var imports: Array<GraphQLComponent> = arrayOf(partnerComponent)
}