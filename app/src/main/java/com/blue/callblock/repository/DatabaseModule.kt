package com.blue.callblock.repository

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    // @Named("RecentCallDao")
    fun provideChannelDao(appDatabase: CallDatabase): CallEventDao {
        return appDatabase.recentCallDao()
    }

    @Provides
    // @Named("CallerDao")
    fun provideChannelDao2(appDatabase: CallDatabase): CallerDao {
        return appDatabase.callerDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CallDatabase {
        return Room.databaseBuilder(
            appContext,
            CallDatabase::class.java,
            "callDatabase"
        ).build()
    }

}