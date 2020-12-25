import com.expediagroup.graphql.plugin.generator.GraphQLClientType.KTOR
import com.expediagroup.graphql.plugin.gradle.tasks.GraphQLGenerateClientTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.20"
    kotlin("plugin.spring") version "1.4.20"
    kotlin("plugin.jpa") version "1.4.20"
    id("com.expediagroup.graphql") version "4.0.0-alpha.8"
}

val gqkKotlin = "4.0.0-alpha.8"
val ktorVersion = "1.3.1"
val spekVersion = "2.0.14"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/spekframework/spek/")
    }
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot", "spring-boot-starter")
    implementation("org.jetbrains.kotlin", "kotlin-reflect")
    implementation("com.expediagroup", "graphql-kotlin-ktor-client", gqkKotlin)
    implementation("com.expediagroup", "graphql-kotlin-schema-generator", gqkKotlin)
    implementation("io.ktor", "ktor-client-okhttp", ktorVersion)
    implementation("io.ktor", "ktor-client-logging-jvm", ktorVersion)
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", "2.11.3")
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8")
    implementation("org.apache.commons", "commons-lang3", "3.11")
    implementation("io.ktor", "ktor-client-core", ktorVersion)
    implementation("io.ktor", "ktor-client-apache", ktorVersion)
    implementation("io.ktor", "ktor-client-gson", ktorVersion)
    implementation("org.junit.jupiter", "junit-jupiter", "5.6.0")
    implementation("org.postgresql", "postgresql")
    implementation("com.graphql-java", "graphql-java-extended-scalars", "1.0")
    implementation("org.valiktor", "valiktor-core", "0.12.0")
}

val graphqlGenerateClient by tasks.getting(GraphQLGenerateClientTask::class) {
    packageName.set("com.shopify.generated")
    schemaFileName.set("${project.projectDir}/src/main/resources/shopifySchema.graphql")
    clientType.set(KTOR)
    queryFileDirectory.set("${project.projectDir}/src/main/resources/query")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
