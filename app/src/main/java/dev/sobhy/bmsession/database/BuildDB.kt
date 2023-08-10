package dev.sobhy.bmsession.database

import android.content.Context
import androidx.room.Room

class BuildDB(private val context: Context) {

    private val userDB by lazy {
        Room.databaseBuilder(context, UserDatabase::class.java, "user_database")
            .allowMainThreadQueries().build()
    }

    fun getDao(): Dao{
        return userDB.userDao()
    }

}