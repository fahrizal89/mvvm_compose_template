package com.fahrizal.mvvmcompose.data.repository.source.network

import com.fahrizal.mvvmcompose.data.api.PrayApi
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NetworkPrayScheduleEntityData @Inject constructor(
    private val prayApi: PrayApi
) {

    fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): Flow<PrayScheduleResponse> {
        return prayApi.getPraySchedule(prayScheduleRequest.city)
    }
}