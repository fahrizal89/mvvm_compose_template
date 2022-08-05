package com.fahrizal.mvvmcompose.data.db.model

import androidx.room.Entity

@Entity(tableName = "pray")
class Pray(
    val time: Long = 0,
    val city: String = "",
    val name: String,
    val id: Long? = null
)