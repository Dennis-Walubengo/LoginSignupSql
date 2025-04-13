package com.walu.loginsignupsql.repository

import androidx.lifecycle.LiveData
import com.walu.loginsignupsql.NotesApp
import com.walu.loginsignupsql.database.NotesDb
import com.walu.loginsignupsql.model.NotesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRepository {
    val database = NotesDb.getDataBase(NotesApp.appContext)
    suspend fun saveNote(notes: NotesData){
        withContext(Dispatchers.IO){
            database.notesDao().insertNote(notes)
        }
    }
    suspend fun deleteNote(note: NotesData) {
        withContext(Dispatchers.IO) {
            database.notesDao().deleteNote(note)
        }
    }
    suspend fun updateNote(notes: NotesData) {
        withContext(Dispatchers.IO) {
            database.notesDao().updateNotes(notes)
        }
    }

    fun getDbNotes():LiveData<List<NotesData>>{
        return database.notesDao().getAllNotes()
    }
    fun getNotesByTitle(title: String): LiveData<NotesData> {
        return database.notesDao().getNotesByTitle(title)
    }


}