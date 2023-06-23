package com.codeBaron.educationalapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.codeBaron.educationalapp.R
import com.codeBaron.educationalapp.navigation.Destinations
import com.codeBaron.educationalapp.ui.theme.Purple40
import com.codeBaron.educationalapp.viewModel.AuthenticationViewModel

/**
 * @author Anyanwu Nicholas
 * @Note This project was developed with "JUST UI in MIND" in mind, somethings with
 * done with real-world best practice(s).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationScreen(
    authenticationViewModel: AuthenticationViewModel = viewModel(),
    navigationController: NavHostController
) {

    val purpleOutlinedTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Purple40,
        unfocusedBorderColor = Purple40,
        errorBorderColor = Color.Red,
        focusedLeadingIconColor = Purple40,
        unfocusedLeadingIconColor = Purple40,
        focusedTrailingIconColor = Purple40,
        unfocusedTrailingIconColor = Purple40
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.designwithdesigners),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .offset(x = 5.dp, y = 0.dp)
                .width(164.dp)
                .height(200.1982.dp)
        )

        Text(
            text = "Create an account",
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Purple40
        )

        Text(
            text = "Name",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Purple40,
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp)
                .fillMaxWidth()
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Name TextField
        OutlinedTextField(
            value = authenticationViewModel.name,
            onValueChange = { authenticationViewModel.name = it },
            label = { Text("Name", style = MaterialTheme.typography.bodyLarge) },
            modifier = Modifier.fillMaxWidth(),
            colors = purpleOutlinedTextFieldColors
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Email Address",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Purple40,
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp)
                .fillMaxWidth()
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Email TextField with validation and icon
        OutlinedTextField(
            value = authenticationViewModel.email,
            onValueChange = {
                authenticationViewModel.email = it
                authenticationViewModel.validateEmail()
            },
            label = { Text("Email", style = MaterialTheme.typography.bodyLarge) },
            modifier = Modifier.fillMaxWidth(),
            isError = authenticationViewModel.emailError.isNotEmpty(),
            visualTransformation = VisualTransformation.None,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_email_24),
                    contentDescription = "Email Icon"
                )
            },
            colors = purpleOutlinedTextFieldColors
        )
        if (authenticationViewModel.emailError.isNotEmpty()) {
            Text(
                text = authenticationViewModel.emailError,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Password",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Purple40,
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp)
                .fillMaxWidth()
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Password TextField with validation and icon
        var passwordVisibility by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = authenticationViewModel.password,
            onValueChange = {
                authenticationViewModel.password = it
                authenticationViewModel.validatePassword()
                authenticationViewModel.validateConfirmPassword()
            },
            label = { Text("Password", style = MaterialTheme.typography.bodyLarge) },
            modifier = Modifier.fillMaxWidth(),
            isError = authenticationViewModel.passwordError.isNotEmpty(),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    val icon = if (passwordVisibility) {
                        painterResource(id = R.drawable.outline_visibility_24)
                    } else {
                        painterResource(id = R.drawable.outline_visibility_off_24)
                    }
                    Icon(
                        painter = icon,
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_lock_24),
                    contentDescription = "Lock Icon"
                )
            },
            colors = purpleOutlinedTextFieldColors
        )
        if (authenticationViewModel.passwordError.isNotEmpty()) {
            Text(
                text = authenticationViewModel.passwordError,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Confirm Password",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Purple40,
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp)
                .fillMaxWidth()
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Confirm Password TextField with validation and icon
        var confirmPasswordVisibility by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = authenticationViewModel.confirmPassword,
            onValueChange = {
                authenticationViewModel.confirmPassword = it
                authenticationViewModel.validateConfirmPassword()
            },
            label = { Text("Confirm Password", style = MaterialTheme.typography.bodyLarge) },
            modifier = Modifier.fillMaxWidth(),
            isError = authenticationViewModel.confirmPasswordError.isNotEmpty(),
            visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                    val icon = if (confirmPasswordVisibility) {
                        painterResource(id = R.drawable.outline_visibility_24)
                    } else {
                        painterResource(id = R.drawable.outline_visibility_off_24)
                    }
                    Icon(
                        painter = icon,
                        contentDescription = "Toggle Confirm Password Visibility"
                    )
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_lock_24),
                    contentDescription = "Lock Icon"
                )
            },
            colors = purpleOutlinedTextFieldColors
        )
        if (authenticationViewModel.confirmPasswordError.isNotEmpty()) {
            Text(
                text = authenticationViewModel.confirmPasswordError,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Sign Up Button
        Button(
            modifier = Modifier
                .offset(x = 0.dp, y = 0.dp)
                .width(352.dp)
                .height(60.dp)
                .background(color = Color(0xFF66328E), shape = RoundedCornerShape(size = 10.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple40,
                contentColor = Color.White,
                disabledContainerColor = Purple40
            ),
            onClick = {
                if (authenticationViewModel.isFormValid()) {
                    navigationController.navigate(Destinations.HOME_SCREEN.name)
                }
            },
            //enabled = authenticationViewModel.isFormValid()
        ) {
            Text("Sign Up", style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = buildAnnotatedString {
                append("Have an account already? ")
                withStyle(style = SpanStyle(color = Purple40)) {
                    appendInlineContent("login", "Log in")
                }
            },
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodyLarge,
            /*color = Purple40,*/
            modifier = Modifier
                .wrapContentSize()
        )
    }
}