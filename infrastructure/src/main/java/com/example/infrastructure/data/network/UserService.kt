package com.example.infrastructure.data.network

import com.example.infrastructure.data.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(
    private val retrofit : ApiClient
) {

    suspend fun getUsers(): List<UserResponse> {
         return withContext(Dispatchers.IO) {
             val response = retrofit.getAllUsers()
             if(retrofit.getAllUsers().isSuccessful){
                 response.body() ?: emptyList()
             } else {
                 emptyList()
             }
        }
    }
}