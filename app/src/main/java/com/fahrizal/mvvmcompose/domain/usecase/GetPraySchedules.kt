package com.fahrizal.mvvmcompose.domain.usecase

import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.data.repository.PrayScheduleRepository
import com.fahrizal.mvvmcompose.util.TimeUtil
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val prayScheduleRepository: PrayScheduleRepository
) {

    operator fun invoke(city: String): Flow<List<Pray>> {
        return prayScheduleRepository.getPraySchedules(PrayScheduleRequest(city, getTodayDate()))
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())
}