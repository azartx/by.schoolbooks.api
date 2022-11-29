package com.example.endpoints

import com.example.model.Subject
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllSubjects() {
    get(path = "/subjects") {
        call.respond(HttpStatusCode.OK, subjects)
    }
}

val subjects = arrayOf(
    Subject(
        "0",
        "Беларуская літаратура"
    ),
    Subject(
        "1",
        "Русская литература"
    )
)
