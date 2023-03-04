package com.example.infrastructure.data.network

import com.example.infrastructure.data.model.PostResponse
import com.example.infrastructure.data.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostService @Inject constructor(
    private val retrofit : ApiClient
) {

    suspend fun getPost(id:Int): List<PostResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getAllPost(id = id)
            response.body() ?: emptyList()
        }
    }
}