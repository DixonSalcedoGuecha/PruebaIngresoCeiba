package com.example.pruebadeingresoceiba.data

import com.example.pruebadeingresoceiba.data.database.dato.PostDao
import com.example.pruebadeingresoceiba.data.database.entities.PostEntity
import com.example.pruebadeingresoceiba.data.network.PostService
import com.example.pruebadeingresoceiba.domain.model.PostItem
import com.example.pruebadeingresoceiba.domain.model.toDomain
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