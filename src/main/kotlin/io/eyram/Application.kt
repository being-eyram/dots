package io.eyram

import io.eyram.routes.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(
        Netty, port = 8080,
        host = "127.0.0.1",
        module = Application::mainModule
    ).start(wait = true)
}

fun Application.mainModule() {
    configurePlugins()

    routing {
        dotRoutes()
    }
}


fun Application.configurePlugins() {
    install(ContentNegotiation) {
        val jsonBuilder = Json {
            isLenient = true
            prettyPrint = true
        }
        json(json = jsonBuilder)
    }
}