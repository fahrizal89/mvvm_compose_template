package com.fahrizal.mvvmcompose.data.repository

import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import kotlinx.coroutines.flow.Flow

interface PrayScheduleRepository {

    fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): Flow<List<Pray>>
}