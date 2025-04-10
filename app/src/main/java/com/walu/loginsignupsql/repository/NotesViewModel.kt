package com.walu.loginsignupsql.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walu.loginsignupsql.model.NotesData
import kotlinx.coroutines.launch

class NotesViewModel:ViewModel() {
    val notesRepo= NotesRepository()
    lateinit var notesLiveData:LiveData<NotesData>
    fun saveNote(notesData: NotesData){
        viewModelScope.launch {
            notesRepo.saveNote(notesData)
        }

    }
    fun updateNote(note: NotesData) {
        viewModelScope.launch {
            notesRepo.updateNote(note)
        }

    }

    fun getNotes():LiveData<List<NotesData>>{
        return notesRepo.getDbNotes()
    }
    fun getNotesByTitle(title: String): LiveData<NotesData> {
        return notesRepo.getNotesByTitle(title)
    }

    }

