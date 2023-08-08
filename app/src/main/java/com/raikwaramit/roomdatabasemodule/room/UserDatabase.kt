package com.raikwaramit.roomdatabasemodule.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room database abstract class for creating the data base.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}