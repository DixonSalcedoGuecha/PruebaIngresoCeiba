package com.example.pruebadeingresoceiba.domain.model

import com.example.pruebadeingresoceiba.data.database.entities.UserEntity
import com.example.pruebadeingresoceiba.data.model.UserResponse

data class UserItem(
    val id: Int = 0,
    val name: String,
    val email: String,
    val phone: String
)

fun UserResponse.toDomain() = UserItem(id, name, email, phone)
fun UserEntity.toDomain() = UserItem(id, name, email, phone)
