package com.example.madarsof.ui.screen

import com.example.madarsof.data.MainCoroutineRule
import com.example.madarsof.data.User
import com.example.madarsof.data.UserRepository
import com.example.madarsof.domain.UserUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`


@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class UserViewModelTest {

    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()

    private lateinit var userUseCases: UserUseCases
    private lateinit var viewModel: UserViewModel

    @Before
    fun setup() {
        userUseCases = mock(UserUseCases::class.java)
        viewModel = UserViewModel(userUseCases)
    }

    @Test
    fun saveUserTest() = runBlockingTest {
        val user = User(name = "John", age = 30, jobTitle = "Developer", gender = "Male")
        viewModel.onEvent(UserEvent.SaveUser(user))
        verify(userUseCases).addUser(user)
    }

    @Test
    fun loadUsersTest() = runBlockingTest {
        val userList = User(name = "John", age = 30, jobTitle = "Developer", gender = "Male")
        `when`(userUseCases.getUser()).thenReturn(userList)
        viewModel.onEvent(UserEvent.LoadUsers)
        assertEquals(userList, viewModel.state.value.user)
    }
}