package com.fahrizal.mvvmcompose.data.mapper

import com.fahrizal.mvvmcompose.data.db.model.Pray
import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
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
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.fajr)),
                    cityName,
                    "Fajr"
                )
            )

            prayList.add(
                Pray(
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.dhuhr)),
                    cityName,
                    "Dhuhr"
                )
            )

            prayList.add(
                Pray(
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.asr)),
                    cityName,
                    "Asr"
                )
            )

            prayList.add(
                Pray(
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.maghrib)),
                    cityName,
                    "Maghrib"
                )
            )

            prayList.add(
                Pray(
                    TimeUtil.getTimestamp(format, dateStr.plus(" ").plus(dataItem.isha)),
                    cityName,
                    "Isha"
                )
            )

        }

        return prayList
    }
}