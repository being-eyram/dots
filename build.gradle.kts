val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.8"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
    id("it.nicolasfarabegoli.conventional-commits") version "3.1.3"

}

group = "io.eyram"
version = "0.0.1"

application {
    mainClass.set("io.eyram.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")

}

repositories {
    mavenCentral()
}

conventionalCommits{
    types += listOf()
    failureMessage = "The commit message does not conform to conventional commits specifications"
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")


    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposed_version")
    implementation("org.postgresql:postgresql:42.7.3")
    //implementation("org.jetbrains.exposed:exposed-crypt:$exposed_version")
}
