package com.example.noteapp.Views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        //Moving to create new note page
        binding.butCreateNote.setOnClickListener {
            val createNoteIntent=Intent(this, CreateNote::class.java)
            startActivity(createNoteIntent)
        }
    }
}