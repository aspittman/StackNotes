package com.affinityapps.stacknotes.layouts.outline

import android.widget.EditText

interface OutlineInterface {
    fun rowToAdd(position:Int)
    fun rowToDelete(position:Int, textFromUser: EditText)
}