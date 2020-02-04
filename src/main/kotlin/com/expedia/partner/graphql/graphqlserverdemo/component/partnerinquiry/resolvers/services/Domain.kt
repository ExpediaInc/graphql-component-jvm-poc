package com.expedia.partner.graphql.graphqlserverdemo.component.partnerinquiry.resolvers.services

import com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services.Partner

data class PartnerInquiry( val id: Long, val partner: Partner )