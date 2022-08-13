package com.fahrizal.mvvmcompose.data.repository.source.network

import com.fahrizal.mvvmcompose.data.api.PrayApi
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import javax.inject.Inject

class NetworkPrayScheduleEntityData @Inject constructor(
    private val prayApi: PrayApi
) {

    suspend fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): PrayScheduleResponse {
        return prayApi.getPraySchedule(prayScheduleRequest.city)
    }
}