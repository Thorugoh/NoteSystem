package org.example.routes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.api.NoteFacade

import org.example.service.model.NoteApi
import org.example.service.NoteService

fun Route.noteRoutes(noteFacade: NoteFacade){
    route("/note") {
        post {
            val body =  call.receive<NoteApi>()
            val note = noteFacade.createNote(body.title, body.description)
            call.respond(HttpStatusCode.Created, NoteApi(note.title, note.description))
        }

        delete("/note/{id}") {
            val id =  call.parameters["id"]
            if(!id.isNullOrBlank()){
                if(noteFacade.removeNote(id)){
                    call.respond(HttpStatusCode.OK)
                }
            }
            call.respond(HttpStatusCode.Conflict)
        }

        patch("/note/{id}") {
            val id =  call.parameters["id"]
            val note = call.receive<NoteApi>()
            if(!id.isNullOrBlank()){
                try{
                    val editedNote = noteFacade.editNote(id, note.title, note.description)
                    call.respond(HttpStatusCode.OK, NoteApi(editedNote.title, editedNote.description))
                }catch (ex: IllegalArgumentException) {
                    call.respond(HttpStatusCode.Conflict)
                }
            }
            call.respond(HttpStatusCode.Conflict)
        }

    }
}