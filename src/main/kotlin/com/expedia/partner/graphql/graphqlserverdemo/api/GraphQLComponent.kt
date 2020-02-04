package com.expedia.partner.graphql.graphqlserverdemo.api

import com.coxautodev.graphql.tools.GraphQLResolver
import com.coxautodev.graphql.tools.SchemaParser
import com.google.common.base.Charsets
import com.google.common.io.Resources.getResource
import com.google.common.io.Resources.toString
import graphql.schema.GraphQLSchema

open class GraphQLComponent: Component {

    private lateinit var schema : GraphQLSchema

    open lateinit var types : Array<String>

    open lateinit var resolvers : Array<GraphQLResolver<*>>

    open var imports : Array<GraphQLComponent> = arrayOf()

    private val federation = false

    fun schema() : GraphQLSchema{
        for(import in this.imports){
            this.types += import.types
            this.resolvers += import.resolvers
        }
        this.schema = SchemaParser.newParser()
                .schemaString(getSchemaFiles().joinToString(separator = " "))  //could add parser here to do excludes feature / better merging
                .resolvers(*this.resolvers)
                .build().makeExecutableSchema()
        return this.schema
    }

    private fun getSchemaFiles() :MutableList<String> {
        val schemas = mutableListOf<String>()
        for(schema in this.types) {
            val schemaFile = getResource(schema)
            val schemaAsString = toString(schemaFile, Charsets.UTF_8)
            schemas.add(schemaAsString)
        }
        return schemas
    }

    override fun federation(): Boolean {
        return this.federation
    }
}
