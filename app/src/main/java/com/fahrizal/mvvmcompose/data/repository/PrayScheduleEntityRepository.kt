package com.fahrizal.mvvmcompose.data.repository

import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import com.fahrizal.mvvmcompose.data.repository.source.network.NetworkPrayScheduleEntityData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrayScheduleEntityRepository @Inject constructor(
    private val networkPrayScheduleEntityData: NetworkPrayScheduleEntityData
) : PrayScheduleRepository {

    override fun getPraySchedules(): Flow<PrayScheduleResponse> {
        return networkPrayScheduleEntityData.getPraySchedules()
    }
}