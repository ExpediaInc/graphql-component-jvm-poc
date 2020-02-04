package com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.Partner
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.PartnerConnection
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.PartnerService
import org.springframework.stereotype.Component

@Component
class PartnerQuery(val partnerService: PartnerService) : GraphQLQueryResolver {

    fun partner(id:String) : Partner {
        return partnerService.getPartner(id)
    }

    fun partners(first: Int, after: Int) : PartnerConnection {
        return partnerService.getAllPartners()
    }
}