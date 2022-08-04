package com.fahrizal.mvvmcompose.di

import com.fahrizal.mvvmcompose.ui.dispatcher.CoroutineDispatcherProvider
import com.fahrizal.mvvmcompose.ui.dispatcher.RealCoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DispatcherModule {

    @Provides
    @Singleton
    fun providesCoroutineDispatcher(): CoroutineDispatcherProvider {
        return RealCoroutineDispatcherProvider()
    }
}
