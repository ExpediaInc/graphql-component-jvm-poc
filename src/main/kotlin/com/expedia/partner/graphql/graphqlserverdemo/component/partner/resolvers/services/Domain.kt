package com.expedia.partner.graphql.graphqlserverdemo.component.partner.resolvers.services

enum class PartnerType { FRBO, PPM, IPM }
data class Partner(val id: Long, val name: String, val type: PartnerType, val internalId: String)
data class PartnerConnection(val totalCount: Int, val edges: MutableList<PartnerEdge>, val pageInfo: PageInfo)
data class PartnerEdge(val node: Partner, val cursor: String)
data class PageInfo(val endCursor: String, val hasNextPage: Boolean)

val partner1 = Partner(13131, "partner1", PartnerType.FRBO, "123131")
val partner2 = Partner(34523, "partner2", PartnerType.IPM, "566322")

