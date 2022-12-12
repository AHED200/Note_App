package com.example.noteapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var id: Int? = null,

    @ColumnInfo(name = "note_title") val noteTitle: String,
    @ColumnInfo(name = "note_description") val noteDescription: String,
    @ColumnInfo(name = "created_at") val created_at: String,
)