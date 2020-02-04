package com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.Partner
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.PartnerService
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.PartnerType
import org.springframework.stereotype.Component

@Component
class PartnerMutation(val partnerService: PartnerService) : GraphQLMutationResolver {
    fun createPartner(name: String, type: PartnerType, internalId: String) : Partner {
        return partnerService.createPartner(name, type, internalId)
    }
}