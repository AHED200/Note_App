package com.example.noteapp.Models.Interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapp.Models.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Note>
}