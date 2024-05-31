package com.example.madarsof.domain

import com.example.madarsof.data.User
import com.example.madarsof.data.UserRepository

class UserUseCases(private val userRepository: UserRepository) {
    suspend fun addUser(user: User) = userRepository.insertUser(user)
    suspend fun getUser(): User? = userRepository.getUser()
}