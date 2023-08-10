package dev.sobhy.bmsession.mainscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import dev.sobhy.bmsession.database.BuildDB
import dev.sobhy.bmsession.database.User
import dev.sobhy.bmsession.database.UserDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    val context = LocalContext.current
    val dbBuilder = BuildDB(context)

    val userDatabase = Room.databaseBuilder(context, UserDatabase::class.java, "user_database")
        .allowMainThreadQueries().build()
    val dao = userDatabase.userDao()
    var users: List<User> = listOf()

    var userName by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }
    var showUser by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(value = userName, onValueChange = { userName = it })
        OutlinedTextField(value = age, onValueChange = { age = it })
        Button(onClick = {
            dbBuilder.getDao().insertUser(User(name = userName, age = age.toInt()))
//            dao.insertUser(User(name = userName, age = age.toInt()))
            userName = ""
            age = ""
        }) {
            Text(text = "Add User")
        }
        Button(onClick = {

            showUser = true

        }) {
            Text(text = "Retrieve Users")
        }
        if(showUser){
            users = dbBuilder.getDao().getAllUsers()
            Column(modifier = Modifier.fillMaxWidth()) {
                repeat(users.size){
                    Text(text = "id: ${users[it].id}, name: ${users[it].name}, age: ${users[it].age}")
                }
            }

        }
    }
}