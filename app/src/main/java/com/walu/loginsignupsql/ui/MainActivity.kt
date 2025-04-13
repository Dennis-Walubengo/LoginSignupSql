package com.walu.loginsignupsql.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.walu.loginsignupsql.databinding.ActivityMainBinding
import com.walu.loginsignupsql.model.NotesData
import com.walu.loginsignupsql.repository.NotesRVAdapter
import com.walu.loginsignupsql.repository.NotesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val notesViewModel: NotesViewModel by viewModels()
    private lateinit var notesAdapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesAdapter = NotesRVAdapter(emptyList(), this,notesViewModel)
        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.adapter = notesAdapter

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddNotesActivity::class.java)
            startActivity(intent)
        }

        notesViewModel.getNotes().observe(this) { notes ->
            displayNotes(notes)
        }
    }

    private fun displayNotes(notesList: List<NotesData>) {
        // Create and set the adapter with updated notes list
        val notesAdapter = NotesRVAdapter(notesList, this,notesViewModel)
        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.adapter = notesAdapter

    }
}
