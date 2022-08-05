package com.fahrizal.mvvmcompose.data.repository

import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.data.mapper.PrayMapper.toListOfPray
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.data.repository.source.local.LocalPrayScheduleEntityData
import com.fahrizal.mvvmcompose.data.repository.source.network.NetworkPrayScheduleEntityData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PrayScheduleEntityRepository @Inject constructor(
    private val networkPrayScheduleEntityData: NetworkPrayScheduleEntityData,
    private val localPrayScheduleEntityData: LocalPrayScheduleEntityData
) : PrayScheduleRepository {

    override fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): Flow<List<Pray>> {
        return localPrayScheduleEntityData.getPraySchedules(prayScheduleRequest)
            .flatMapConcat { prayList ->
                if (prayList.isNotEmpty()) {
                    return@flatMapConcat flow { emit(prayList) }
                } else {
                    return@flatMapConcat syncPrayScheduleFromNetwork(prayScheduleRequest)
                }
            }
    }

    private fun syncPrayScheduleFromNetwork(prayScheduleRequest: PrayScheduleRequest): Flow<List<Pray>> {
        return networkPrayScheduleEntityData.getPraySchedules(prayScheduleRequest)
            .map { prayScheduleResponse ->
                prayScheduleResponse.toListOfPray()
            }
            .flatMapConcat { prayList ->
                localPrayScheduleEntityData.savePraySchedules(prayList)
            }
    }
}