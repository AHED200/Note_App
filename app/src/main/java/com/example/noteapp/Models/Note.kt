package com.example.noteapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "note_title") val noteTitle: String,
    @ColumnInfo(name = "note_description") val noteDescription: String,
    @ColumnInfo(name = "created_at") val created_at: String
)