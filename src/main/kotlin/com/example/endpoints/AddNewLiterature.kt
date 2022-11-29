package com.example.endpoints

import com.example.db.DatabaseFactory
import com.example.db.LiteratureTable
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.jetbrains.exposed.sql.insert

fun Route.addNewBook() {
    post(path = "/add") {
        call.parameters.apply {
            try {
                val id = getOrFail("id").toInt()
                val subjectId = getOrFail("subjectId").toInt()
                val name = getOrFail("name")
                val description = getOrFail("description")
                val author = getOrFail("author")
                val url = getOrFail("url")
                val imageUrl = getOrFail("imageUrl")
                val className = getOrFail("className").toInt()

                DatabaseFactory.dbQuery {
                    val lit = LiteratureTable.insert {
                        it[LiteratureTable.litName] = name
                        it[LiteratureTable.litDescription] = description
                        it[LiteratureTable.litAuthor] = author
                        it[LiteratureTable.forSubjectId] = subjectId
                        it[LiteratureTable.litUrl] = url
                        it[LiteratureTable.litImageUrl] = imageUrl
                        it[LiteratureTable.litClass] = className
                    }.resultedValues?.firstOrNull()

                    println(lit.toString())
                    call.respond(HttpStatusCode.OK, "Success")
                }

            } catch (e: Exception) {
                e.printStackTrace()
                if (e is MissingRequestParameterException) {
                    call.respond(HttpStatusCode.BadRequest, "Some of queries is not sent")
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Bad request data. ${e.message}")
                }
            }
        }
    }
}
