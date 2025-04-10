package com.walu.loginsignupsql.database

import android.util.JsonWriter
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.walu.loginsignupsql.model.NotesData

class CustomTypeAdapter: TypeAdapter<NotesData>() {
    override fun write(out: com.google.gson.stream.JsonWriter, value: NotesData) {
        value?.let {
            out.beginObject() // Start writing the object
            out.name("id").value(it.id)
            out.name("title").value(it.title)
            out.name("content").value(it.content)

            out.endObject() // End writing the object
        }
    }

    override fun read(`in`: JsonReader): NotesData {
        var id = 0
        var title = ""
        var content = ""


        `in`.beginObject() // Start reading the object
        while (`in`.hasNext()) {
            when (`in`.nextName()) {
                "id" -> id = `in`.nextInt()
                "title" -> title = `in`.nextString()
                "content" -> content= `in`.nextString()
                else -> `in`.skipValue()
            }
        }
        `in`.endObject() // End reading the object

        return NotesData(id,title, content)
    }
}