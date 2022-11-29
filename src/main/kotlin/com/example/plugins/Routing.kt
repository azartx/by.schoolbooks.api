package com.example.plugins

import com.example.endpoints.addNewBook
import com.example.endpoints.getAllSubjects
import com.example.endpoints.getLiteratureBySubjectId
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import java.io.File

fun Application.configureRouting() {
    routing {
        getLiteratureBySubjectId()
        getAllSubjects()
        addNewBook()
        // Static plugin. Try to access `/static/index.html`
        static("static") {
            resources("static")
        }
    }
}
