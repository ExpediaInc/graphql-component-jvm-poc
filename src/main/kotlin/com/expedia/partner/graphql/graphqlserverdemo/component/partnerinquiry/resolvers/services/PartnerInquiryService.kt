package com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.resolvers.services

import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.Partner
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.PartnerType
import org.springframework.stereotype.Service

@Service
class PartnerInquiryService {
    fun getPartnerInquiry(id: String?): PartnerInquiry {
        return PartnerInquiry(3242342, Partner(2342342, "Partner2", PartnerType.PPM, "13123"))
    }

}