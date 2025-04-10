package com.walu.loginsignupsql.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.walu.loginsignupsql.databinding.ActivityNotesDetailsBinding
import com.walu.loginsignupsql.repository.NotesViewModel

class NotesDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesDetailsBinding
    private val notesViewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("CONTACT_TITLE")

        if (title != null) {
            notesViewModel.getNotesByTitle(title).observe(this) { note ->
                binding.tvTitle.text = note.title
                binding.tvContent.text = note.content
            }
        }
    }
}
