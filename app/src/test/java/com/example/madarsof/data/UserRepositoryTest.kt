package com.example.madarsof.data


import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`




@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class UserRepositoryTest {

    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()

    private lateinit var userDao: UserDao
    private lateinit var repository: UserRepository

    @Before
    fun setup() {
        userDao = mock(UserDao::class.java)
        repository = UserRepositoryImp(userDao)
    }

    @Test
    fun insertUserTest() = runBlockingTest {
        val user = User(name = "John", age = 30, jobTitle = "Developer", gender = "Male")
        repository.insertUser(user)
        verify(userDao).insertUser(user)
    }

    @Test
    fun getAllUsersTest() = runBlockingTest {
        val userList = User(name = "John", age = 30, jobTitle = "Developer", gender = "Male")
        `when`(userDao.getUser()).thenReturn(userList)
        val result = repository.getUser()
        assertEquals(userList, result)
    }


}