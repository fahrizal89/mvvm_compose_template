package com.fahrizal.mvvmcompose.data.repository

import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.data.mapper.PrayMapper.toListOfPray
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.data.repository.source.local.LocalPrayScheduleEntityData
import com.fahrizal.mvvmcompose.data.repository.source.network.NetworkPrayScheduleEntityData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PrayScheduleEntityRepository @Inject constructor(
    private val networkPrayScheduleEntityData: NetworkPrayScheduleEntityData,
    private val localPrayScheduleEntityData: LocalPrayScheduleEntityData
) : PrayScheduleRepository {

    override fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): Flow<List<Pray>> {
        return localPrayScheduleEntityData.getPraySchedules(prayScheduleRequest)
            .map { prayList ->
                if (prayList.isEmpty()) {
                    syncPrayScheduleFromNetwork(prayScheduleRequest)
                }
                return@map prayList
            }
    }

    private suspend fun syncPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest) {
        val response = networkPrayScheduleEntityData.getPraySchedules(prayScheduleRequest)
        localPrayScheduleEntityData.save(response.toListOfPray())
    }
}