package org.example
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*
import org.example.api.NoteFacade
import org.example.repository.NoteRepositoryImpl
import org.example.routes.noteRoutes
import org.example.service.NoteService

fun main() {
    val noteRepository = NoteRepositoryImpl()
    val noteService = NoteService(noteRepository)
    val noteFacade = NoteFacade(noteService)

    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation){
            json()
        }
        routing {
            noteRoutes(noteFacade)
        }
    }.start(wait = true)
}