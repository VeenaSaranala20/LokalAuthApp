package com.example.lokalauthapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lokalauthapp.analytics.AnalyticsLogger
import com.example.lokalauthapp.data.OtpManager

class AuthViewModel : ViewModel() {

    private val otpManager = OtpManager()
    val state = mutableStateOf(AuthState())

    fun sendOtp(email: String) {
        otpManager.generateOtp(email)
        AnalyticsLogger.otpGenerated()
        state.value = state.value.copy(email = email, screen = Screen.OTP)
    }

    fun verifyOtp(otp: String) {
        val result = otpManager.validateOtp(state.value.email, otp)
        if (result == null) {
            AnalyticsLogger.otpSuccess()
            state.value = state.value.copy(
                screen = Screen.SESSION,
                sessionStart = System.currentTimeMillis()
            )
        } else {
            AnalyticsLogger.otpFailure()
            state.value = state.value.copy(error = result)
        }
    }

    fun logout() {
        AnalyticsLogger.logout()
        state.value = AuthState()
    }
}
