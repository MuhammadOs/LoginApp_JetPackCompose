package com.example.loginapp_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
            composable("login_page", content = {
                LogincScreen(navController = navController)
            })
            composable("register_page", content = {
                SignupScreen(navController = navController)
            })
            composable("newProfile_page/{firstName}&{lastName}&{email}&{age}",
                arguments = listOf(
                    navArgument("firstName") { type = NavType.StringType},
                    navArgument("lastName") { type = NavType.StringType},
                    navArgument("email") { type = NavType.StringType},
                    navArgument("age") { type = NavType.IntType}
                ),
                content = {
                    val firstName = it.arguments?.getString("firstName") ?: "No firstname added"
                    val lastName = it.arguments?.getString("lastName") ?: "No firstname added"
                    val email = it.arguments?.getString("email") ?: "No email added"
                    val age = it.arguments?.getInt("age") ?: 0
                    NewProfile(navController = navController, firstName, lastName, email, age)})

            composable("Home_page", content = { HomePage(navController = navController) })
            composable("first_page", content = { Screen(profiles = getDummyProfiles(), profileListiner = {
                Toast.makeText(navController.context, it.Name, Toast.LENGTH_SHORT)
                    .show()
            } ,navController = NavController(LocalContext.current)) })
            composable("second_page", content = { LazyTask(getDummyNames(), navController = NavController(LocalContext.current)) })
        }
    )
}