package com.example.madarsof.di

import android.content.Context
import androidx.room.Room
import com.example.madarsof.data.UserDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ): UserDatabase = Room.databaseBuilder(
        app, UserDatabase::class.java, "user-dp"
    ).fallbackToDestructiveMigration()
        .build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideUniversityDao(db: UserDatabase) =
        db.userDao() // The reason we can implement a Dao for the database


}