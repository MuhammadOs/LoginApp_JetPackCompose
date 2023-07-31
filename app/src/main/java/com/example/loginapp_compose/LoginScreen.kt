package com.example.loginapp_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginapp_compose.ui.theme.BMInternshipTheme


class LogincompScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
         LogincScreen(navController = NavController(LocalContext.current))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogincScreen (navController: NavController){
    val context = LocalContext.current
    val showPassword = remember { mutableStateOf(false) }
    var username: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var clicked: Boolean by remember { mutableStateOf(false) }
    var checked: Boolean by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {
                navController.navigate("register_page")
            },
            style = TextStyle(
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.DarkGray
            )
        )
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            Modifier.align(Alignment.Start),
            style = TextStyle(fontSize = 40.sp),
        )
        Text(
            text = "Please sign in to continue",
            Modifier.align(Alignment.Start),
            style = TextStyle(fontSize = 18.sp),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            leadingIcon = {
                          Icon(
                              imageVector = ImageVector.vectorResource(id = R.drawable.baseline_account_circle_24),
                              contentDescription = "")
            },
            label = { Text(text = "Username") },
            value = username,
            singleLine = true,
            onValueChange = { newValue -> username = newValue })

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            leadingIcon = {
                androidx.compose.material3.Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_lock_24),
                    contentDescription = "")
            },
            trailingIcon = {
                           IconButton(
                               onClick = {
                               showPassword.value = !showPassword.value
                           }) {
                               androidx.compose.material3.Icon(
                                   imageVector = ImageVector.vectorResource(id = R.drawable.baseline_remove_red_eye_24),
                                   contentDescription = "")
                           }
            },
            singleLine = true,
            label = { Text(text = "Password") },
            value = password,
            visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { newValue -> password = newValue })

        Spacer(modifier = Modifier.height(10.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
                )
        {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked_ -> checked = checked_
                },
            )
            Text(text = "Remember me")
        }


        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                //enabled = password.isNotEmpty() && username.isNotEmpty(),
                onClick = {
                    clicked = true
                    when {
                        username.isEmpty() -> {
                            Toast.makeText(
                                context,
                                "Please enter username!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        password.isEmpty() -> {
                            Toast.makeText(
                                context,
                                "Please enter the password!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        else -> {
                            Toast.makeText(
                                context,
                                "Logged Successfully!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("Forget Password?"),
            onClick = {
            },
            style = TextStyle(
                fontSize = 14.sp,
            ),
        )
        Spacer(modifier = Modifier.height(40.dp))
        /*if(clicked) {
            Text("Logged in successfully")
        }*/
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun LogincompScreenPreview() {
    BMInternshipTheme {
        com.example.loginapp_compose.LogincScreen(navController = NavController(LocalContext.current))
    }
}