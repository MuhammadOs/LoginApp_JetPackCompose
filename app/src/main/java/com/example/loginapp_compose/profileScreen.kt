package com.example.loginapp_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


class ProfileScreen (navController: NavController): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            /*Screen(profiles = getDummyProfiles(), profileListiner = {
                Toast
                    .makeText(this, it.Name, Toast.LENGTH_SHORT)
                    .show()
            } ,navController = NavController(LocalContext.current))*/
            NewProfile(navController = NavController(LocalContext.current), "", "", "", 0)
        }
    }
}

data class Profile(val Name: String, val Job: String)

@Composable
fun getDummyProfiles(): List<com.example.loginapp_compose.Profile> {
    return listOf(
        Profile("John", "Software Engineer"),
        Profile("Alice", "Designer"),
        Profile("Bob", "Data Scientist"),
        Profile("Emily", "Product Manager"),
        Profile("Michael", "Marketing Specialist"),
        Profile("Olivia", "Teacher"),
        Profile("David", "Doctor"),
        Profile("Sophia", "Accountant"),
        Profile("Daniel", "Sales Manager"),
        Profile("Emma", "HR Manager"),
        Profile("William", "Graphic Designer"),
        Profile("Ava", "Lawyer"),
        Profile("James", "Chef"),
        Profile("Isabella", "Architect"),
        Profile("Alexander", "Financial Analyst"),
        Profile("Mia", "Journalist"),
        Profile("Ethan", "Mechanical Engineer"),
        Profile("Charlotte", "Nurse"),
        Profile("Oliver", "Photographer"),
        Profile("Amelia", "Researcher")
    )
}

@Composable
fun Toasting(navController: NavController) {
    /*Toast
        .makeText(navController.context, item.Name, Toast.LENGTH_SHORT)
        .show()*/
}

@Composable
fun NewProfile(
    navController: NavController,
    firstName: String,
    lastName: String,
    email: String,
    age: Int
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Card(
            modifier = Modifier
                .size(400.dp, 150.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(10))
                .clickable {
                    navController.navigate("first_page")
                }
        ) {
            Row(
                Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "",
                    Modifier.size(80.dp)
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row() {
                        Text(text = firstName, modifier = Modifier.align(Alignment.CenterVertically))
                        Text(text = lastName, modifier = Modifier.align(Alignment.CenterVertically))
                    }
                    Text(text = email,modifier = Modifier.align(Alignment.CenterHorizontally))
                    Text(text = age.toString(),modifier = Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }
    }
}



@Composable
fun Screen (profiles: List<com.example.loginapp_compose.Profile>, profileListiner: (com.example.loginapp_compose.Profile) -> Unit, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        IconButton(
            modifier = Modifier
                .padding(10.dp),
            onClick = {
                navController.navigate(route = "login_page")
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = ""
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            itemsIndexed(profiles) { index, item ->
                Card(
                    modifier = Modifier
                        .size(400.dp, 120.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10))
                        .clickable {
                            profileListiner(profiles.get(index))
                        }
                ) {
                    Row(
                        Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_account_circle_24),
                            contentDescription = "",
                            Modifier.size(80.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(text = item.Name, modifier = Modifier
                                .align(Alignment.Start)
                                )
                            Text(text = item.Job, modifier = Modifier.align(Alignment.Start))
                        }
                    }
                }
            }
        }
    }
    }