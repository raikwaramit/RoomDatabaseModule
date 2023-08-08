package com.raikwaramit.roomdatabasemodule.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * data class representing the table and its column for the room database.
 */
@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "phone") val phone: String,
)

/*
// We can also create our own primary key.
@Entity
data class User(
    @PrimaryKey @ColumnInfo(name = "user_id") val userid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "phone") val phone: String,
)
*/