package com.expedia.partner.graphql.graphqlserverdemo.component.partner

import com.coxautodev.graphql.tools.GraphQLResolver
import com.expedia.partner.graphql.graphqlserverdemo.api.GraphQLComponent
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.PartnerMutation
import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.PartnerQuery
import org.springframework.stereotype.Component

@Component
class PartnerComponent(partnerQuery: PartnerQuery, partnerMutation: PartnerMutation) :
        GraphQLComponent(){
    override var types = arrayOf("partner-types.graphqls", "partner-component.graphqls")
    override var resolvers: Array<GraphQLResolver<*>>  = arrayOf(partnerQuery, partnerMutation)
}
