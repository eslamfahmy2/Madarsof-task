package com.example.madarsof.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madarsof.data.User
import com.example.madarsof.domain.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class UserState(
    val user: User? = null,
    val isSaved: Boolean = false
)

sealed class UserEvent {
    data class SaveUser(val user: User) : UserEvent()
    object LoadUsers : UserEvent()
}

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    private val _state = mutableStateOf(UserState())
    val state: State<UserState> = _state

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.SaveUser -> {
                viewModelScope.launch {
                    userUseCases.addUser(event.user)
                    _state.value = state.value.copy(isSaved = true)
                }
            }
            is UserEvent.LoadUsers -> {
                viewModelScope.launch {
                    val users = userUseCases.getUser()
                    _state.value = state.value.copy(user = users)
                }
            }
        }
    }

   /* fun insertUser(user: User) {
        viewModelScope.launch {
            userUseCases.addUser(user)
        }
    }

    fun getUser(onResult: (User?) -> Unit) {
        viewModelScope.launch {
            onResult(userUseCases.getUser())
        }
    }*/
}