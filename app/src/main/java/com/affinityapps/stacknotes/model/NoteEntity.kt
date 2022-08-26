package com.affinityapps.stacknotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    val noteId:String,
    val userText:String
)