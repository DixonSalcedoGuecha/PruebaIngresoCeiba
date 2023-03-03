package com.example.pruebadeingresoceiba.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebadeingresoceiba.data.database.dato.UserDao
import com.example.pruebadeingresoceiba.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class CeibaDataBase: RoomDatabase() {
    abstract fun getUserDao():UserDao
}