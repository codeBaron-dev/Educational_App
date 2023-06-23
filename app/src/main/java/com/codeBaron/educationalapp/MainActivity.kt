package com.codeBaron.educationalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.codeBaron.educationalapp.navigation.NavigationManager
import com.codeBaron.educationalapp.screens.AuthenticationScreen
import com.codeBaron.educationalapp.ui.theme.EducationalAppTheme
import com.codeBaron.educationalapp.viewModel.AuthenticationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EducationalAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationManager(mainActivity = this)
                    //AuthenticationScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EducationalAppTheme {
        AuthenticationScreen(authenticationViewModel = AuthenticationViewModel(), rememberNavController())
    }
}