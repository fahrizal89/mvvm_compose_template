package com.fahrizal.mvvmcompose.data.repository.source.network

import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkPrayScheduleEntityData {

    fun getPraySchedules(): Flow<PrayScheduleResponse> {
        return flow {
            PrayScheduleResponse()
        }
    }
}