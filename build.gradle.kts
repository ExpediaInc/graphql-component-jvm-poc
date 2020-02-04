import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "com.expedia.partner.graphql"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    //node
    implementation("com.moowork.gradle:gradle-node-plugin:1.3.1")

    //graphql
    implementation("com.graphql-java:graphql-java:11.0")
    implementation("com.graphql-java:graphql-java-tools:5.2.4")

    //kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //apollo
    implementation("com.apollographql.apollo:apollo-gradle-plugin:1.2.2")
    implementation("com.apollographql.apollo:apollo-runtime:0.4.1")

    //spring
    implementation( "com.graphql-java:graphql-spring-boot-starter:5.0.2")
    implementation("com.graphql-java:graphiql-spring-boot-starter:5.0.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.graphql-java-kickstart:graphql-java-tools:5.4.0")
    implementation("org.springframework:spring-webflux")
    implementation("org.springframework:spring-core:5.2.3.RELEASE")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
//task downloadSchema(type: NodeTask) {
  //  script = file('src/main/node/component.js')
   // ignoreExitValue = true
//}
