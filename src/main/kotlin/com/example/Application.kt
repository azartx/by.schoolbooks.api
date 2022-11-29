package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.db.DatabaseFactory

fun main() {
    embeddedServer(Netty, port = 8854, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    //configureSecurity()
    configureRouting()
}
