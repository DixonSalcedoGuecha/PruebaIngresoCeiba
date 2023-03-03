package com.example.pruebadeingresoceiba.data.network

import com.example.pruebadeingresoceiba.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {
    @GET("/users")
    suspend fun getAllUsers():Response<List<UserResponse>>
}