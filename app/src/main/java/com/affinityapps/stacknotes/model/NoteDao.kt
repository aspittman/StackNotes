package com.affinityapps.stacknotes.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun insertNotes(notes: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<NoteEntity>>

    @Update
    fun updateNotes(notes: NoteEntity)

    @Delete
    fun deleteNotes(notes: NoteEntity)
}