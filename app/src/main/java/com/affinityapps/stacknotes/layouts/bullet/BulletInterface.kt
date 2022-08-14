package com.affinityapps.stacknotes.layouts.bullet

import android.widget.EditText

interface BulletInterface {
    fun rowToAdd(position:Int, textFromUser: EditText)
    fun rowToDelete(position:Int, textFromUser: EditText)
}