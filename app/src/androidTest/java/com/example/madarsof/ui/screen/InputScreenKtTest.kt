package com.example.madarsof.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import com.example.madarsof.data.User
import com.example.madarsof.data.UserRepository
import com.example.madarsof.domain.UserUseCases
import com.example.madarsof.ui.theme.MadarsofTheme
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class UserFormScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var userViewModel: UserViewModel
    private lateinit var userUseCases: UserUseCases

    @Before
    fun setUp() {
        val userRepository = FakeUserRepository()
        userUseCases = UserUseCases(userRepository)
        userViewModel = UserViewModel(
            userUseCases = userUseCases,
        )
        composeTestRule.setContent {
            MadarsofTheme {
                InputScreen(navController = rememberNavController(), userViewModel = userViewModel)

            }
        }
    }


    @Test
    fun testUserFormScreen() {

        composeTestRule.onNodeWithText("Name").performTextInput("John")
        composeTestRule.onNodeWithText("Age").performTextInput("30")
        composeTestRule.onNodeWithText("Job Title").performTextInput("Developer")
        composeTestRule.onNodeWithText("Gender").performTextInput("Male")

        composeTestRule.onNodeWithText("Save").performClick()


        Assert.assertEquals(true, userViewModel.state.value.isSaved)

    }
}