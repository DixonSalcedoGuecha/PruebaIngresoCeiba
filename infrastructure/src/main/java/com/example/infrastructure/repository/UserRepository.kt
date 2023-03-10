package com.example.infrastructure.repository

import com.example.infrastructure.data.database.dato.UserDao
import com.example.infrastructure.data.database.entities.UserEntity
import com.example.infrastructure.data.network.UserService
import com.example.domain.model.UserItem
import com.example.infrastructure.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val userDao: UserDao
) {

    suspend fun getAllUsersFromApi(): List<UserItem> {
        val response = api.getUsers()
        return response.map { it.toDomain() }
    }

    suspend fun getAllUsersFromDataBase(): List<UserItem> {
        val response = userDao.getAllUsers()
        return response.map { it.toDomain() }
    }

    suspend fun insertUser(user: List<UserEntity>) {
        userDao.insertAll(user)

    }
}