package com.example.pruebadeingresoceiba.data.network

import com.example.pruebadeingresoceiba.core.RetrofitHelper
import com.example.pruebadeingresoceiba.data.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create
import javax.inject.Inject

class UserService @Inject constructor(
    private val retrofit : UserApiClient
) {



    suspend fun getUsers(): List<UserResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getAllUsers()
            response.body() ?: emptyList()
        }
    }
}