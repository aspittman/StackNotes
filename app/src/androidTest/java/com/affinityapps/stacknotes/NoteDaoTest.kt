package com.affinityapps.stacknotes

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.affinityapps.stacknotes.model.NoteDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteDaoTest {
    private lateinit var dataBase:NoteDatabase

    @Before fun initDb() {
        dataBase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            NoteDatabase::class.java).build()
    }

    @Test fun testFunction() {
        dataBase.noteDao().getAllNotes()
    }

    @After fun closeDb() {
        dataBase.close()
    }
}