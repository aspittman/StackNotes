package com.affinityapps.stacknotes

import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.affinityapps.stacknotes.model.NoteDao
import com.affinityapps.stacknotes.model.NoteDatabase
import com.affinityapps.stacknotes.model.NoteEntity
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteDaoTest : TestCase(){
    private lateinit var dataBase:NoteDatabase
    private lateinit var dao: NoteDao

    @Before fun initDb() {
        dataBase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            NoteDatabase::class.java).build()
    }

    @Test fun testFunction() {
        val notDataInsertTest = NoteEntity("234", "asdf")
        dao.insertNotes(notDataInsertTest)
        assert(dataBase.noteDao().findNotes("234").equals("asdf"))
    }

    @After fun closeDb() {
        dataBase.close()
    }
}