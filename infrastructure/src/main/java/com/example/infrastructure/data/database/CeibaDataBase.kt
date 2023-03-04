package com.example.infrastructure.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.infrastructure.data.database.dato.PostDao
import com.example.infrastructure.data.database.dato.UserDao
import com.example.infrastructure.data.database.entities.PostEntity
import com.example.infrastructure.data.database.entities.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = 1)
abstract class CeibaDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getPostDao(): PostDao
}