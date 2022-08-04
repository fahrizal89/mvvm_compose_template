package com.fahrizal.mvvmcompose.di

import com.fahrizal.mvvmcompose.data.repository.PrayScheduleEntityRepository
import com.fahrizal.mvvmcompose.data.repository.PrayScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PrayModule {

    @Provides
    @Singleton
    fun providePrayScheduleRepository(prayScheduleEntityRepository: PrayScheduleEntityRepository): PrayScheduleRepository {
        return prayScheduleEntityRepository
    }
}