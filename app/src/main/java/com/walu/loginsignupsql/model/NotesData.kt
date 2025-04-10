package com.walu.loginsignupsql.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.walu.loginsignupsql.database.CustomTypeAdapter

@Entity(tableName = "Notes")
data class NotesData(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title: String,
    var content: String,

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(content)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NotesData> {
        override fun createFromParcel(parcel: Parcel): NotesData {
            return NotesData(parcel)
        }

        override fun newArray(size: Int): Array<NotesData?> {
            return arrayOfNulls(size)
        }
    }
}

val gson: Gson = GsonBuilder()
    .registerTypeAdapter(NotesData::class.java, CustomTypeAdapter())
    .create()


