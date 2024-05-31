package com.example.madarsof.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DisplayScreen(userViewModel: UserViewModel) {


    val state by userViewModel.state

    LaunchedEffect(Unit) {
        userViewModel.onEvent(UserEvent.LoadUsers)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        state.user?.let {
            Text("Name: ${it.name}")
            Text("Age: ${it.age}")
            Text("Job Title: ${it.jobTitle}")
            Text("Gender: ${it.gender}")
        } ?: Text("No user data found")
    }
}