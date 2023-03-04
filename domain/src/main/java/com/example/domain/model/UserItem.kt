package com.example.domain.model

import java.io.Serializable

data class UserItem(
    val id: Int = 0,
    val name: String,
    val email: String,
    val phone: String
): Serializable
