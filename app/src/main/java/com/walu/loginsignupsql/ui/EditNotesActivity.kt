package com.walu.loginsignupsql.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.walu.loginsignupsql.databinding.ActivityEditNotesBinding
import com.walu.loginsignupsql.model.NotesData
import com.walu.loginsignupsql.repository.NotesViewModel

class EditNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditNotesBinding
    private lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        val noteId = intent.getIntExtra("note_id", -1)
        val noteTitle = intent.getStringExtra("note_title")
        val noteContent = intent.getStringExtra("note_content")

        binding.etTitle.setText(noteTitle)
        binding.etContent.setText(noteContent)

        binding.btnSave.setOnClickListener {
            val updatedTitle = binding.etTitle.text.toString()
            val updatedContent = binding.etContent.text.toString()

            if (updatedTitle.isNotEmpty() && updatedContent.isNotEmpty()) {
                val updatedNote = NotesData(noteId, updatedTitle, updatedContent)
                notesViewModel.updateNote(updatedNote)
                Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Fields can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
