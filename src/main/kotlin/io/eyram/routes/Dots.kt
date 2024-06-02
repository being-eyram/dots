package io.eyram.routes

import io.eyram.db.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.dotRoutes() {
    val database = DatabaseFactory.db

    post("/api/dot") {
        call.respond(mapOf("hello" to "world"))
    }

    get("/api/dots") {
        call.respondText("get all notes")
    }

    get("/api/dots/{id}") {

        val noteId = call.parameters["id"]
        call.respondText("get note with id : $noteId")

    }

    put("/api/dots/{id}") {
        val noteId = call.parameters["id"]
        call.respondText("update note with id : $noteId")
    }

    get("/api/dots/search") {
        call.respondText("search results")
    }
}
