package com.example.pruebadeingresoceiba.data.network

import com.example.pruebadeingresoceiba.data.model.PostResponse
import com.example.pruebadeingresoceiba.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("/users")
    suspend fun getAllUsers():Response<List<UserResponse>>

    @GET("/posts")
    suspend fun getAllPost(@Query("userId") id: Int):Response<List<PostResponse>>
}