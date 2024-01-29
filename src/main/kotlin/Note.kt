package org.example

data class Note (val id: String, var title: String, var description: String, var isDone: Boolean){
    fun editNote(title: String = this.title, description: String = this.description) {
        this.title = title;
        this.description = description
    }
}