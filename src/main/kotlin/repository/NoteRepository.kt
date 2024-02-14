package org.example.repository

import org.example.model.Note

interface NoteRepository {
    fun createNote(item: Note): Note
    fun editNote(item: Note): Note
    fun removeNote(id: String): Boolean

}