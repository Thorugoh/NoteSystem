package org.example

class System {
    private var notes = mutableListOf<Note>()

    fun createNote(title: String, description: String): Note{
        val id = "some-id"
        val note = Note(id, title, description, false)
        notes.add(note)
        return note
    }

    fun removeNote(id: String) {
        val note = notes.find { it.id == id }
        notes.remove(note)
    }

    fun editNote(id: String, title: String?, description: String?){
        val note = notes.find { it.id == id }
        if(title != null && description != null) {
            note?.editNote(title, description)
        }
    }

}