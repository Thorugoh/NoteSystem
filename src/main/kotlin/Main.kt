package org.example
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*

fun main() {
    val system = System()

    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation){
            json()
        }
        routing {
            post("/note", ) {
                val body =  call.receive<NoteApi>()
                val note = system.createNote(body.title, body.description)
//                    call.respond(HttpStatusCode.Created, gson.toJson(note))

            }

        }
    }.start(wait = true)
}