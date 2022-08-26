package com.affinityapps.stacknotes.model

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun insertNotes(noteEntity: NoteEntity) =
        noteDao.insertNotes(noteEntity)

    fun getAllNotes(): LiveData<List<NoteEntity>> = noteDao.getAllNotes()

    suspend fun updateNotes(noteEntity: NoteEntity) =
        noteDao.updateNotes(noteEntity)

    suspend fun deleteNotes(noteEntity: NoteEntity) =
        noteDao.deleteNotes(noteEntity)
}