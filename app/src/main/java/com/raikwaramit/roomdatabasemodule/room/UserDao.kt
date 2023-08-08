package com.raikwaramit.roomdatabasemodule.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    // Add or update the existing user data
    @Upsert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}