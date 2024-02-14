package org.example.model

data class Note (val id: String, var title: String, var description: String){
    fun editNote(title: String = this.title, description: String = this.description) {
        this.title = title;
        this.description = description
    }
}