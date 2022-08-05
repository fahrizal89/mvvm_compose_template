package com.fahrizal.mvvmcompose.di

import com.fahrizal.mvvmcompose.data.db.AppDatabase
import com.fahrizal.mvvmcompose.data.db.AppRoomDatabase
import com.fahrizal.mvvmcompose.data.db.dao.PrayDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideAppRoomDatabase(appDatabase: AppDatabase): AppRoomDatabase {
        return appDatabase.roomDb
    }

    @Provides
    fun providePrayDao(appRoomDatabase: AppRoomDatabase): PrayDao {
        return appRoomDatabase.prayDao()
    }
}