package com.example.pruebadeingresoceiba.data

import com.example.pruebadeingresoceiba.data.model.UserResponse
import com.example.pruebadeingresoceiba.data.model.UsersListProvider
import com.example.pruebadeingresoceiba.data.network.UserService

class UserRepository {

    private var api = UserService()

    suspend fun getAllUsers(): List<UserResponse>{
        val response = api.getUsers()
        UsersListProvider.users = response
        return response
    }
}