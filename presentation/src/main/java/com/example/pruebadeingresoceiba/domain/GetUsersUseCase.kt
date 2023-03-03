package com.example.pruebadeingresoceiba.domain

import com.example.pruebadeingresoceiba.data.UserRepository
import com.example.pruebadeingresoceiba.data.database.entities.toDataBase
import com.example.pruebadeingresoceiba.domain.model.UserItem
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository : UserRepository
) {

    suspend operator fun invoke (): List<UserItem> {
        var user = repository.getAllUsersFromDataBase()

       return user.ifEmpty {
           user = repository.getAllUsersFromApi()
           repository.insertUser(user.map { it.toDataBase() })
           user
       }

    }
}