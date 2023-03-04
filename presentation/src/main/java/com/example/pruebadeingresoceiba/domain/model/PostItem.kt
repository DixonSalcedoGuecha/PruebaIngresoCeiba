package com.example.pruebadeingresoceiba.domain.model

import com.example.pruebadeingresoceiba.data.database.entities.PostEntity
import com.example.pruebadeingresoceiba.data.database.entities.UserEntity
import com.example.pruebadeingresoceiba.data.model.PostResponse
import com.example.pruebadeingresoceiba.data.model.UserResponse

data class PostItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun PostResponse.toDomain() = PostItem(userId,id, title , body)
fun PostEntity.toDomain() = PostItem(userId, id, title, body)
