package com.fahrizal.mvvmcompose.di

import com.fahrizal.mvvmcompose.data.api.PrayApi
import com.fahrizal.mvvmcompose.data.repository.PrayScheduleEntityRepository
import com.fahrizal.mvvmcompose.data.repository.PrayScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PrayModule {

    @Provides
    @Singleton
    fun providePrayScheduleRepository(prayScheduleEntityRepository: PrayScheduleEntityRepository): PrayScheduleRepository {
        return prayScheduleEntityRepository
    }

    @Provides
    @Singleton
    fun providePrayApi(retrofit: Retrofit): PrayApi = retrofit.create(PrayApi::class.java)

}