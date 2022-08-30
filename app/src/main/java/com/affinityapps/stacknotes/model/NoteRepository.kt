package com.affinityapps.stacknotes.model

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class NoteRepository(private val noteDao: NoteDao) {

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun insertNotes(noteEntity: NoteEntity) =
        noteDao.insertNotes(noteEntity)

  //  fun getAllNotes(): Flow<List<NoteEntity>> = noteDao.getAllNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateNotes(noteEntity: NoteEntity) =
        noteDao.updateNotes(noteEntity)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteNotes(noteEntity: NoteEntity) =
        noteDao.deleteNotes(noteEntity)
}