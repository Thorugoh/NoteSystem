package org.example.repository

import org.example.model.Note

class NoteRepositoryImpl: NoteRepository{
    private var notes = mutableListOf<Note>()

    override fun createNote(item: Note): Note {
        notes.add(item)
        return item
    }

    override fun removeNote(id: String): Boolean {
        val note = notes.find { it.id == id }
        if(note != null) {
            notes.remove(note)
            return true;
        }
        return false;
    }

    override fun editNote(item: Note): Note{
        val note = notes.find { it.id == item.id }
        if(note != null){
            note.editNote(item.description, item.title)
            return note;
        }
        throw IllegalArgumentException("Item not found")
    }
}