package com.blue.callblock.repository

import android.content.Context
import com.tencent.mmkv.MMKV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppPreferencesModule {

    @Provides
    @Singleton
    fun provideAppPreference(@ApplicationContext appContext: Context): MMKV? {
        MMKV.initialize(appContext)
        return MMKV.defaultMMKV()
    }
}