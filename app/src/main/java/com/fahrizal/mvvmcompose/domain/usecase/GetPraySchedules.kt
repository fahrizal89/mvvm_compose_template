package com.fahrizal.mvvmcompose.domain.usecase

import com.fahrizal.mvvmcompose.data.model.PrayScheduleRequest
import com.fahrizal.mvvmcompose.data.repository.PrayScheduleRepository
import com.fahrizal.mvvmcompose.domain.mapper.PrayMapper.toListOfPray
import com.fahrizal.mvvmcompose.domain.model.Pray
import com.fahrizal.mvvmcompose.util.TimeUtil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val prayScheduleRepository: PrayScheduleRepository
) {

    operator fun invoke(city: String): Flow<List<Pray>> {
        val prayScheduleRequest = PrayScheduleRequest(city, getTodayDate())

        return prayScheduleRepository.getPraySchedules(prayScheduleRequest)
            .map { prayScheduleResponse ->
                prayScheduleResponse.toListOfPray()
            }
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())
}