package com.fahrizal.mvvmcompose.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fahrizal.mvvmcompose.data.db.model.Pray
import kotlinx.coroutines.flow.Flow

@Dao
interface PrayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: List<Pray>)

    @Query("SELECT * FROM pray WHERE city = :city AND time >= :from AND time <= :to")
    fun getPraySchedule(city: String, from: Long, to: Long): Flow<List<Pray>>

}