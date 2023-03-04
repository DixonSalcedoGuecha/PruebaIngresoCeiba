package com.example.infrastructure.repository

import com.example.infrastructure.data.database.dato.PostDao
import com.example.infrastructure.data.database.entities.PostEntity
import com.example.infrastructure.data.network.PostService
import com.example.domain.model.PostItem
import com.example.infrastructure.data.model.toDomain
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: PostService,
    private val postDao: PostDao
) {

    suspend fun getIdUserPostFromApi(id: Int): List<PostItem> {
        val response = api.getPost(id = id)
        return response.map { it.toDomain() }
    }

    suspend fun getIdUserPostFromDataBase(id: Int): List<PostItem> {
        val response = postDao.getIdPost(id)
        return response.map { it.toDomain() }
    }

    suspend fun insertPost(post: List<PostEntity>) {
        postDao.insertAll(post)

    }
}