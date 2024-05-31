package com.example.madarsof.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import com.example.madarsof.domain.UserUseCases
import com.example.madarsof.ui.MainActivity
import com.example.madarsof.ui.theme.MadarsofTheme
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class UserListScreenTest {


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
                DisplayScreen(userViewModel = userViewModel)

            }
        }
    }


    @Test
    fun testUserFormScreen() {
        // Verify that the user data is displayed correctly
        composeTestRule.onNodeWithText("Name: John, Age: 30, Job Title: Developer, Gender: Male")
            .assertIsDisplayed()
    }

}