package com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.resolvers.services.PartnerInquiry
import com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.resolvers.services.PartnerInquiryService
import org.springframework.stereotype.Component

@Component
class PartnerInquiryQuery (val partnerInquiryService: PartnerInquiryService): GraphQLQueryResolver {
    fun partnerinquiry(id : String) :PartnerInquiry{
        return partnerInquiryService.getPartnerInquiry(id)
    }
}