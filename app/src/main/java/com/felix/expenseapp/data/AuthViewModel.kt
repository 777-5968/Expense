package com.felix.expenseapp.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Authentication UI state
data class AuthState(
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val error: String? = null,
    val userEmail: String? = null
)

class AuthViewModel : ViewModel() {

    private val _authState = MutableStateFlow(AuthState())
    val authState: StateFlow<AuthState> = _authState

    // Fake login function (replace with Firebase/Auth API)
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState(isLoading = true)

            // Simulate API delay
            kotlinx.coroutines.delay(1500)

            if (email == "test@example.com" && password == "123456") {
                _authState.value = AuthState(
                    isAuthenticated = true,
                    userEmail = email
                )
            } else {
                _authState.value = AuthState(
                    isAuthenticated = false,
                    error = "Invalid email or password"
                )
            }
        }
    }

    fun signup(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState(isLoading = true)

            // Simulate API delay
            kotlinx.coroutines.delay(1500)

            // In real app, call Firebase/Auth API
            _authState.value = AuthState(
                isAuthenticated = true,
                userEmail = email
            )
        }
    }

    fun logout() {
        _authState.value = AuthState(isAuthenticated = false)
    }

    fun clearError() {
        _authState.value = _authState.value.copy(error = null)
    }
}
