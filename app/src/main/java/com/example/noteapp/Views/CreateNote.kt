package com.example.noteapp.Views

import NoteViewModel
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.Models.Note
import com.example.noteapp.databinding.ActivityCreateNoteBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CreateNote : AppCompatActivity() {

    private lateinit var binding: ActivityCreateNoteBinding
    lateinit var noteViewModel: NoteViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        noteViewModel = NoteViewModel(this)

        binding.butCreateNote.setOnClickListener {
            val noteTitle: String = binding.etNoteTitle.text.trim().toString()
            val noteDescription: String = binding.etNoteDescription.text.trim().toString()

            //Works if the note title is empty
            if (noteTitle.isEmpty()) {
                Toast.makeText(this, "The note title is empty", Toast.LENGTH_SHORT).show()
            } else {
                //Get current date with time
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                val current = LocalDateTime.now().format(formatter)

                //Define the Note object and NoteViewModel
                val newNote = Note(null, noteTitle, noteDescription, current)

                //Insert the new note to the database
                noteViewModel.insertNote(newNote)
                //Update the current notes list
                

                //Show toast and quit the CreateNote activity
                Toast.makeText(this, "The note is inserted successfully", Toast.LENGTH_SHORT).show()
                finish()
            }


        }
    }
}