package org.example.service.model

import kotlinx.serialization.*

@Serializable
data class NoteApi(
    val title: String,
    val description: String,
)
