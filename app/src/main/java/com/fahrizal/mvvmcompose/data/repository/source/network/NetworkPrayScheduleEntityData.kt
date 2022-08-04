package com.fahrizal.mvvmcompose.data.repository.source.network

import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkPrayScheduleEntityData @Inject constructor() {

    fun getPraySchedules(): Flow<PrayScheduleResponse> {
        return flow {
            emit(PrayScheduleResponse())
        }
    }
}