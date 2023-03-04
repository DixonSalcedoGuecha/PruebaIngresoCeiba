package com.example.infrastructure

import com.example.domain.model.UserItem
import com.example.infrastructure.data.database.entities.UserEntity
import com.example.infrastructure.data.model.UserResponse

fun UserResponse.toDomain() = UserItem(id, name, email, phone)
fun UserEntity.toDomain() = UserItem(id, name, email, phone)
