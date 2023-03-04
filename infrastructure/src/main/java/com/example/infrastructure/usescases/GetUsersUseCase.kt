package com.example.infrastructure.usescases


import com.example.domain.model.UserItem
import com.example.infrastructure.repository.UserRepository
import com.example.infrastructure.data.database.entities.toDataBase
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