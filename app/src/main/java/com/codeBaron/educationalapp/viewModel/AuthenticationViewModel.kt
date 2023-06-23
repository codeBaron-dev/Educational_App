package com.codeBaron.educationalapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class AuthenticationViewModel : ViewModel() {

    // State for form fields
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    // State for validation errors
    var emailError by mutableStateOf("")
    var passwordError by mutableStateOf("")
    var confirmPasswordError by mutableStateOf("")

    // Validation functions
    fun validateEmail() {
        emailError = if (email.isEmpty()) {
            "Email is required."
        } else if (!Pattern.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email)) {
            "Invalid email address."
        } else {
            ""
        }
    }

    fun validatePassword() {
        passwordError = if (password.isEmpty()) {
            "Password is required."
        } else if (password.length < 6) {
            "Password must be at least 6 characters long."
        } else {
            ""
        }
    }

    fun validateConfirmPassword() {
        confirmPasswordError = if (confirmPassword.isEmpty()) {
            "Confirm password is required."
        } else if (password != confirmPassword) {
            "Passwords do not match."
        } else {
            ""
        }
    }

    // Check if all form fields are valid
    fun isFormValid(): Boolean {
        validateEmail()
        validatePassword()
        validateConfirmPassword()
        return emailError.isEmpty() && passwordError.isEmpty() && confirmPasswordError.isEmpty()
    }
}