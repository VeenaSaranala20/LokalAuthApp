package com.example.lokalauthapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.lokalauthapp.viewmodel.AuthViewModel
import com.example.lokalauthapp.viewmodel.Screen
import com.example.lokalauthapp.ui.*
import com.example.lokalauthapp.uiscreens.LoginScreen

@Composable
fun AppEntry() {
    val viewModel = remember { AuthViewModel() }
    val state = viewModel.state.value

    when (state.screen) {
        Screen.LOGIN -> LoginScreen(viewModel)
        Screen.OTP -> OtpScreen(viewModel)
        Screen.SESSION -> SessionScreen(viewModel)
    }
}
