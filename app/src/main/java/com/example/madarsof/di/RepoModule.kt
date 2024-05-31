package com.example.madarsof.di

import com.example.madarsof.data.UserDao
import com.example.madarsof.data.UserRepository
import com.example.madarsof.data.UserRepositoryImp
import com.example.madarsof.domain.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository
            = UserRepositoryImp(userDao)

    @Singleton
    @Provides
    fun provideUserUseCases(userRepository: UserRepository): UserUseCases
    = UserUseCases(userRepository)


}