package com.fahrizal.mvvmcompose.domain.mapper

import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import com.fahrizal.mvvmcompose.domain.model.Pray

object PrayScheduleMapper {

    fun PrayScheduleResponse.toListOfPray(): List<Pray> {
        val prayList = ArrayList<Pray>()

        return prayList
    }
}