package com.fahrizal.mvvmcompose.data.api

import com.fahrizal.mvvmcompose.BuildConfig
import com.fahrizal.mvvmcompose.data.model.PrayScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayApi {

    @GET("/jakarta/daily.json")
    suspend fun getPraySchedule(
        @Query("city") city: String,
        @Query("key") key: String? = BuildConfig.API_KEY
    ): PrayScheduleResponse
}