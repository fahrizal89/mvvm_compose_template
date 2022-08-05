package com.fahrizal.mvvmcompose.domain.mapper

import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import com.fahrizal.mvvmcompose.domain.model.Pray
import com.fahrizal.mvvmcompose.util.TimeUtil

object PrayMapper {

    fun PrayScheduleResponse.toListOfPray(): List<Pray> {
        val prayList = ArrayList<Pray>()
        val cityName = state ?: ""
        val format = "yyyy-M-dd hh:mm a"

        items?.get(0)?.let { dataItem ->
            val dateStr = dataItem.date_for

            prayList.add(
                Pray(
                    cityName, "Fajr",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.fajr))
                )
            )

            prayList.add(
                Pray(
                    cityName, "Dhuhr",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.dhuhr))
                )
            )

            prayList.add(
                Pray(
                    cityName, "Asr",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.asr))
                )
            )

            prayList.add(
                Pray(
                    cityName, "Maghrib",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.maghrib))
                )
            )

            prayList.add(
                Pray(
                    cityName, "Isha",
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.isha))
                )
            )

        }

        return prayList
    }
}