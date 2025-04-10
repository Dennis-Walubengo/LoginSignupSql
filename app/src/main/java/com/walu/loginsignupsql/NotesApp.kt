package com.walu.loginsignupsql

import android.app.Application
import android.content.Context

class NotesApp :Application() {
    companion object{
        lateinit var appContext:Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }
}