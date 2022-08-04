package com.fahrizal.mvvmcompose.data.repository

import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import kotlinx.coroutines.flow.Flow

interface PrayScheduleRepository {

    fun getPraySchedules(): Flow<PrayScheduleResponse>
}