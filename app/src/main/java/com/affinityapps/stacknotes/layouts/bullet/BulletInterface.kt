package com.affinityapps.stacknotes.layouts.bullet

import android.widget.EditText

interface BulletInterface {
    fun rowToAdd(position:Int)
    fun rowToDelete(position:Int, textFromUser: EditText)
}