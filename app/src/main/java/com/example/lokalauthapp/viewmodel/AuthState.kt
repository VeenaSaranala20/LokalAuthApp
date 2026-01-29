package com.example.lokalauthapp.viewmodel


data class AuthState(
    val email: String = "",
    val screen: Screen = Screen.LOGIN,
    val error: String? = null,
    val sessionStart: Long = 0L
)

enum class Screen {
    LOGIN, OTP, SESSION
}
