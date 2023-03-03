package com.example.pruebadeingresoceiba.domain.model

import com.example.pruebadeingresoceiba.data.database.entities.UserEntity
import com.example.pruebadeingresoceiba.data.model.UserResponse

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)

fun UserResponse.toDomain() = User(id, name, email, phone)
fun UserEntity.toDomain() = User(id, name, email, phone)
