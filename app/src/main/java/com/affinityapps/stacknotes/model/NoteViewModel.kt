package com.affinityapps.stacknotes.model

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    fun insert(note:NoteEntity) = viewModelScope.launch {
        repository.insertNotes(note)
    }

 //   val selectAllNotes : LiveData<List<NoteEntity>> = repository.getAllNotes().asLiveData()

    fun update(note:NoteEntity) = viewModelScope.launch {
        repository.updateNotes(note)
    }

    fun delete(note: NoteEntity) = viewModelScope.launch {
        repository.deleteNotes(note)
    }
}

class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
