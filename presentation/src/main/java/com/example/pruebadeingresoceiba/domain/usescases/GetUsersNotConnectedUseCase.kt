package com.example.pruebadeingresoceiba.domain.usescases

import com.example.pruebadeingresoceiba.data.UserRepository
import com.example.pruebadeingresoceiba.domain.model.UserItem
import javax.inject.Inject

class GetUsersNotConnectedUseCase @Inject constructor(
    private val repository : UserRepository
) {

    suspend operator fun invoke (): List<UserItem> {
        val user = repository.getAllUsersFromDataBase()
        return user.ifEmpty { emptyList() }

    }
}