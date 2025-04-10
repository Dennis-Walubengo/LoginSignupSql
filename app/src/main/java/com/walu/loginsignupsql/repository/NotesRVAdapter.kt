package com.walu.loginsignupsql.repository

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walu.loginsignupsql.databinding.NoteListBinding
import com.walu.loginsignupsql.model.NotesData
import com.walu.loginsignupsql.ui.EditNotesActivity
import com.walu.loginsignupsql.ui.NotesDetailsActivity

class NotesRVAdapter(private var notesList: List<NotesData>, val context: Context) : RecyclerView.Adapter<NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = NoteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = notesList[position]
        val binding = holder.binding

        binding.tvTitle.text = currentNote.title
        binding.tvContent.text = currentNote.content

        binding.card.setOnClickListener {
            val intent = Intent(context, NotesDetailsActivity::class.java)
            intent.putExtra("CONTACT_TITLE", currentNote.title)
            context.startActivity(intent)
        }

        binding.editIcon.setOnClickListener {
            val intent = Intent(context, EditNotesActivity::class.java)
            intent.putExtra("note_id", currentNote.id)
            intent.putExtra("note_title", currentNote.title)
            intent.putExtra("note_content", currentNote.content)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = notesList.size

    fun updateNotes(newNotes: List<NotesData>) {
        notesList = newNotes
        notifyDataSetChanged()
    }
}

class NotesViewHolder(val binding: NoteListBinding) : RecyclerView.ViewHolder(binding.root)
