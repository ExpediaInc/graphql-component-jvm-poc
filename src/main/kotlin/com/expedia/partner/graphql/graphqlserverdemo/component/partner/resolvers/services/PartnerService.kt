package com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services

import org.springframework.stereotype.Component

@Component
class PartnerService {
    fun getPartner(id: String) : Partner {
        return partner1
    }

    fun getAllPartners(): PartnerConnection {
        return PartnerConnection(2, mutableListOf(PartnerEdge(partner1, partner1.id.toString())
        ,PartnerEdge(partner1, partner2.id.toString())),
                PageInfo(partner2.id.toString(), false))
    }

    fun createPartner (name: String, type: PartnerType, internalId: String) : Partner {
        return Partner(4444, name, type, internalId)
    }
}