package com.example.pruebadeingresoceiba.data.network

import com.example.pruebadeingresoceiba.core.RetrofitHelper
import com.example.pruebadeingresoceiba.data.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class UserService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUsers(): List<UserResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UserApiClient::class.java).getAllUsers()
            response.body() ?: emptyList()
        }
    }
}