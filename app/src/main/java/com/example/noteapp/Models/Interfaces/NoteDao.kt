package com.example.noteapp.Models.Interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapp.Models.Note

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNotes():LiveData<List<Note>>
}