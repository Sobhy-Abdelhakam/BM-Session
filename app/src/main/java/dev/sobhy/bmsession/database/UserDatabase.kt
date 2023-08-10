package dev.sobhy.bmsession.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): Dao

}