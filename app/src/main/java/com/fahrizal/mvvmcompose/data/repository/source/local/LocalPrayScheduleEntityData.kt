package com.fahrizal.mvvmcompose.data.repository.source.local

import com.fahrizal.mvvmcompose.data.db.dao.PrayDao
import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.util.TimeUtil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalPrayScheduleEntityData @Inject constructor(
    private val prayDao: PrayDao
) {

    fun getPraySchedules(prayScheduleRequest: PrayScheduleRequest): Flow<List<Pray>> {
        val from = TimeUtil.getTimestamp("yyyy-MM-dd", prayScheduleRequest.date)
        val to = TimeUtil.getTimestamp("yyyy-MM-dd", prayScheduleRequest.date, 1)

        return prayDao.getPraySchedule(prayScheduleRequest.city, from, to)
    }

    fun savePraySchedules(prayList: List<Pray>): Flow<List<Pray>> {
        return flow {
            prayDao.insert(prayList)
            emit(prayList)
        }
    }
}