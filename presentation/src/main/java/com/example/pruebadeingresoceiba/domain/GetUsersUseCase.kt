package com.example.pruebadeingresoceiba.domain

import com.example.pruebadeingresoceiba.data.UserRepository
import com.example.pruebadeingresoceiba.data.model.UserResponse

class GetUsersUseCase {
    private val repository = UserRepository()

    suspend operator fun invoke (): List<UserResponse> {
        return repository.getAllUsers()
    }
}