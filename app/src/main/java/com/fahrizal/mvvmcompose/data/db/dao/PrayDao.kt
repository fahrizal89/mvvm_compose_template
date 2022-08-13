package com.fahrizal.mvvmcompose.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fahrizal.mvvmcompose.data.db.model.Pray
import kotlinx.coroutines.flow.Flow

@Dao
interface PrayDao {

    @Query("SELECT * FROM pray WHERE city = :city AND time >= :from AND time <= :to")
    fun getPraySchedule(city: String, from: Long, to: Long): Flow<List<Pray>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: List<Pray>)
}