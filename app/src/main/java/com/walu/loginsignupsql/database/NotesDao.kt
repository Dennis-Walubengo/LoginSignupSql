package com.walu.loginsignupsql.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.walu.loginsignupsql.model.NotesData

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(notesData: NotesData)

    @Query("SELECT * FROM Notes ORDER BY id")
    fun getAllNotes():LiveData<List<NotesData>>

    @Query("SELECT * FROM Notes Where title= :title LIMIT 1")
    fun getNotesByTitle(title: String): LiveData<NotesData>

    @Update
    suspend fun updateNotes(notesData: NotesData)

    @Delete
    suspend fun deleteNote(notesData: NotesData)

}