package com.fahrizal.mvvmcompose.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pray")
class Pray(
    @PrimaryKey val time: Long = 0,
    val city: String = "",
    val name: String,
    val id: Long? = null
)