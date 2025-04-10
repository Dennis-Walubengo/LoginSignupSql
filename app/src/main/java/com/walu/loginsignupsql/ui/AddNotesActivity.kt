package com.walu.loginsignupsql.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.walu.loginsignupsql.databinding.ActivityAddNotesBinding
import com.walu.loginsignupsql.model.NotesData
import com.walu.loginsignupsql.repository.NotesViewModel

class AddNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNotesBinding
    private val notesViewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            validateAndCreateNote()
        }
    }

    private fun validateAndCreateNote() {
        val title = binding.etTitle.text.toString().trim()
        val content = binding.etContent.text.toString().trim()
        var hasError = false

        binding.tilTitle.error = null
        binding.tilContent.error = null

        if (title.isBlank()) {
            binding.tilTitle.error = "Title required"
            hasError = true
        }

        if (content.isBlank()) {
            binding.tilContent.error = "Content required"
            hasError = true
        }

        if (!hasError) {
            val newNote = NotesData(
                id = 0,
                title = title,
                content = content
            )
            notesViewModel.saveNote(newNote)
            Toast.makeText(this, "Note created", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
