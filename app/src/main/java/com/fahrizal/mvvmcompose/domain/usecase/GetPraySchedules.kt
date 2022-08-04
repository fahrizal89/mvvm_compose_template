package com.fahrizal.mvvmcompose.domain.usecase

import com.fahrizal.mvvmcompose.data.repository.PrayScheduleRepository
import com.fahrizal.mvvmcompose.domain.mapper.PrayScheduleMapper.toListOfPray
import com.fahrizal.mvvmcompose.domain.model.Pray
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPraySchedules @Inject constructor(
    private val prayScheduleRepository: PrayScheduleRepository
) {

    operator fun invoke(): Flow<List<Pray>> {
        return prayScheduleRepository.getPraySchedules()
            .map { prayScheduleResponse ->
                prayScheduleResponse.toListOfPray()
            }
    }
}