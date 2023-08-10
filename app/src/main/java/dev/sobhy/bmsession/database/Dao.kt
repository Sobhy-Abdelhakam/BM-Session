package dev.sobhy.bmsession.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  Dao {
    @Insert
    fun insertUser(user: User)
    @Query("select * from user_table")
    fun getAllUsers(): List<User>
}