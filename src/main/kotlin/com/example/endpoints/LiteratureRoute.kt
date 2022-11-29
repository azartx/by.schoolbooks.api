package com.example.endpoints

import com.example.db.LiteratureTable
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getLiteratureBySubjectId() {
    get(path = "/subject-literature") {
        val subjectId = call.parameters["subjectId"]
        if (subjectId == null) {
            call.respond(HttpStatusCode.BadRequest, "You must provide the subject id!")
        } else {
            val literature = LiteratureTable.dao.getLiteratureBySubjectId(subjectId.toInt())
            call.respond(HttpStatusCode.OK, literature)
        }
    }
}
