package com.example.madarsof.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.madarsof.data.User
import com.example.madarsof.ui.navigation.Destinations


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(
    userViewModel: UserViewModel,
    navController: NavController
) {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var jobTitle by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("fdfdd") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

            )
        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = jobTitle,
            onValueChange = { jobTitle = it },
            label = { Text("Job Title") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

            )
        TextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gender") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),

            )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val user = User(
                    name = name,
                    age = age.toIntOrNull() ?: 0,
                    jobTitle = jobTitle,
                    gender = gender,
                    id = 1
                )
                // val user = User(name = name, age = age.toIntOrNull() ?: 0, jobTitle = jobTitle, gender = gender)
                userViewModel.onEvent(UserEvent.SaveUser(user))

                // userViewModel.insertUser(user)
                navController.navigate(Destinations.DisplayScreen.route)
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Save")
        }
    }
}