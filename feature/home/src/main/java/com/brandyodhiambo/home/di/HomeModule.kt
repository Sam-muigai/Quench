package com.brandyodhiambo.home.di

import com.brandyodhiambo.common.domain.repository.SleepTimeRepository
import com.brandyodhiambo.dao.SleepTimeDao
import com.brandyodhiambo.home.data.repository.SleepTimeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideSleepRepository(sleepTimeDao: SleepTimeDao): SleepTimeRepository {
        return SleepTimeRepositoryImpl(sleepTimeDao = sleepTimeDao)
    }


}