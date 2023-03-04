package com.example.infrastructure.data.model

import com.example.domain.model.PostItem
import com.example.infrastructure.data.database.entities.PostEntity
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)
fun PostResponse.toDomain() = PostItem(userId,id, title , body)
fun PostEntity.toDomain() = PostItem(userId, id, title, body)