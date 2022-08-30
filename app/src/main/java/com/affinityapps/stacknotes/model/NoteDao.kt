package com.affinityapps.stacknotes.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun insertNotes(notes: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<NoteEntity>>

    @Query("SELECT * from notes where noteId = noteId")
    fun findNotes(noteId : String)

    //Idea here is note is ignored if it's already the same
    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateNotes(notes: NoteEntity)

    @Delete
    fun deleteNotes(notes: NoteEntity)
}