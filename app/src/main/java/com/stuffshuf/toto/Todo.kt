package com.stuffshuf.toto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id:Long?= null,
    val title:String,
    val desc:String
)
