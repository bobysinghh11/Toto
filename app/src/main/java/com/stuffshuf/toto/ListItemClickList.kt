package com.stuffshuf.toto

import androidx.room.RoomDatabase

interface ListItemClickList {

   //fun checkBoxListener(todo: Todo)
    fun delButtonListener(todo: Todo, position:Int)

}