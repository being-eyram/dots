package io.eyram

import io.eyram.db.DatabaseFactory
import io.eyram.db.models.Notes
import io.eyram.db.models.Users
import io.eyram.routes.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(
        Netty, port = 8080,
        host = "127.0.0.1",
        module = Application::mainModule,
    ).start(wait = true)
}

fun Application.mainModule() {
    initializeDB()
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

fun initializeDB() {
    transaction(DatabaseFactory.db) {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Users, Notes)
    }
}