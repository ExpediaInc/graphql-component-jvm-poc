# graphql-component-jvm-poc

This is a proof of concept that follows the same approach to graphQL
development as the javascript based [graphql component node framework](https://github.com/ExpediaGroup/graphql-component).
The primary principals are schema first design broken down into micro graphs that
can be bundled together in any combination to form a larger graph.

The concept of this POC is to port this approach to run on a JVM web server for teams that
are heavily invested in Java technologies.  Included in the POC
is a node script that can export schemas from existing components written in node.  At
this time resolvers would need be rewritten for the JVM but a longer term concept has
been researched to leverage Kotlin to fully interoperable with Node modules

### Project outline

```
--main
-----kotlin
---------api // core of GraphQL Component framework (to be split into new project)
---------component // implementation of components
---------config // application configuration
---------handlers // application controllers
-----node //scripts from importing node compoents
-----resources // home of config and schema files
```

### Running 
This POC is written with gradle and spring-boot to start run the following

```
 ./gradlew bootRun
```

Then navigate to 
```
http://localhost:8080/graphiql
```
to test the schemas in a browser.

###Implementing a component 

1. Create new schema files in the resources file
2. Create a component class extending GraphQLComponent
3. Create resolvers for each query, mutation, subscription, etc by extending the appropriate subs class of GraphQLResolver
4. Pass resolvers and schema file locations through the constructor of the new component class
5. Composed components can be created by passing sub components in through the imports field
6. The top level component is then passed to the graphQL handler class.  
7. Call the schema() method on the component in the handler to create an executable schema for the 
server to run

###Missing pieces
Since this was a time boxed exercise not all features of GraphQL Component are implemented including
1. Conflict resolution: Conflicting top level objects will not be merged automatically in this version.
This will need to be done manually until a better schema parser is written.
2. Excludes: graphQL Component allows some elements to be filtered out of a schema 
this too would require some extensions to the schema merging feature.
3. Runtime JavaScript execution: currently javascript can only run at build time to export a schema.
Executing JavaScript resolvers is left out for now.
4. Compiling Kotlin Component to node module:  It is possible to write a component fully
in Kotin and have that compiled to a JavaScript node module to run on a JavaScript based server. 
 This concept was exercised in another POC and is currently omitted from this project.
 
Further development of this project is on pause until adoption use cases are found