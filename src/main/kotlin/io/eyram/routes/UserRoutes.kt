package io.eyram.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


 fun Route.userRoutes() {

     post("/api/dot/") {
         call.respond(mapOf("hello" to "world"))
     }

     get("/api/dots") {
         call.respondText("get all notes")
     }

 }