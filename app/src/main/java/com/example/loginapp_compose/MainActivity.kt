package com.example.loginapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapp_compose.ui.theme.BMInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMInternshipTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    navigatePage()
                    //Screen(profiles = getDummyProfiles())
                }
            }
        }
    }
}

@Composable
fun navigatePage() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login_page",
        builder = {
            composable("login_page", content = { LogincScreen(navController = navController) })
            composable("register_page", content = { SignupScreen(navController = navController) })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMInternshipTheme() {
        Screen()
    }
}