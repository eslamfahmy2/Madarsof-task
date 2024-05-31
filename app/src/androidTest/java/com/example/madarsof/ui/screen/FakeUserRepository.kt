package com.example.madarsof.ui.screen

import com.example.madarsof.data.User
import com.example.madarsof.data.UserRepository

class FakeUserRepository() : UserRepository {

    private var innerUser: User? = null

    override suspend fun insertUser(user: User) {
        innerUser = user
    }

    override suspend fun getUser(): User? {
        return innerUser
    }

}