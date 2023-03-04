package com.example.infrastructure.core.di

import android.content.Context
import androidx.room.Room
import com.example.infrastructure.data.database.CeibaDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val NAME_DATABASE = "ceiba_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CeibaDataBase::class.java, NAME_DATABASE).build()

    @Singleton
    @Provides
    fun provideUserDao(db: CeibaDataBase) = db.getUserDao()

    @Singleton
    @Provides
    fun providePostDao(db: CeibaDataBase) = db.getPostDao()
}