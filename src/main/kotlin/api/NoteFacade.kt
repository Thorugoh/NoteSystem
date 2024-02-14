package org.example.api

import org.example.model.Note
import org.example.service.NoteService

class NoteFacade(private val noteService: NoteService) {
    fun createNote(title: String, description: String): Note = noteService.createNote(title, description)
    fun removeNote(id: String): Boolean = noteService.removeNote(id)
    fun editNote(id: String, title: String, description: String): Note = noteService.editNote(id, title, description)
}