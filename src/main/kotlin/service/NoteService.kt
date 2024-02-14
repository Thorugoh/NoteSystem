package org.example.service

import org.example.model.Note
import org.example.repository.NoteRepository

class NoteService(private val repository: NoteRepository) {
    fun createNote(title: String, description: String): Note {
        return repository.createNote(Note("some-id", title, description))
    }
    fun removeNote(id: String): Boolean = repository.removeNote(id)
    fun editNote(id: String, title: String, description: String): Note {
       return repository.editNote(Note(id, title, description))
    }
}
        