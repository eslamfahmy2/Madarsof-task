package com.example.madarsof.data


interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun getUser() : User?
}

class UserRepositoryImp(private val userDao: UserDao) : UserRepository {
    override suspend fun insertUser(user: User) = userDao.insertUser(user)
    override suspend fun getUser() = userDao.getUser()
}