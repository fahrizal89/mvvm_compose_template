package com.fahrizal.mvvmcompose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fahrizal.mvvmcompose.data.db.dao.PrayDao
import com.fahrizal.mvvmcompose.data.db.model.Pray

@Database(
    version = 1,
    entities = [Pray::class],
    exportSchema = true
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun prayDao(): PrayDao
}