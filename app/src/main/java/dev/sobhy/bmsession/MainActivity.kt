package dev.sobhy.bmsession

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.sobhy.bmsession.mainscreens.HomeScreen
import dev.sobhy.bmsession.mainscreens.ProfileScreen
import dev.sobhy.bmsession.mainscreens.SearchScreen
import dev.sobhy.bmsession.ui.theme.BMSessionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMSessionTheme {

                CreateScaffold()
            }
        }
    }
}

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun CreateScaffold() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { createTopBar() },
        bottomBar = { createBottomAppBar(navController) },
        floatingActionButton = {}
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {

            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen()
                }
                composable("search") {
                    SearchScreen()
                }
                composable("profile") {
                    ProfileScreen()
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createTopBar() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        title = {
            Text(text = "Title")
        },
        actions = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
        })
}

@Composable
fun createBottomAppBar(navController: NavHostController) {
    var selectedItem by remember {
        mutableStateOf("home")
    }

    BottomAppBar {
        NavigationBarItem(selected = selectedItem == "home", onClick = { /*TODO*/ }, icon = {
            IconButton(onClick = {
                selectedItem = "home"
                navController.navigate("home")
            }) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "home"
                )
            }
        })
        NavigationBarItem(selected = selectedItem == "search", onClick = { /*TODO*/ }, icon = {
            IconButton(onClick = {
                selectedItem = "search"
                navController.navigate("search")
            }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search"
                )
            }
        })
        NavigationBarItem(selected = selectedItem == "profile", onClick = { /*TODO*/ }, icon = {
            IconButton(onClick = {
                selectedItem = "profile"
                navController.navigate("profile")
            }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "profile"
                )
            }
        })
    }
}