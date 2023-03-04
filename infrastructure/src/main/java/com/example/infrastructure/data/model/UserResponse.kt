package com.example.infrastructure.data.model

import com.example.domain.model.UserItem
import com.example.infrastructure.data.database.entities.UserEntity
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")  val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String
)

