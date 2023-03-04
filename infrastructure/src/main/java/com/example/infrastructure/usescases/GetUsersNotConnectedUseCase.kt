package com.example.infrastructure.usescases

import com.example.domain.model.UserItem
import com.example.infrastructure.repository.UserRepository
import javax.inject.Inject

class GetUsersNotConnectedUseCase @Inject constructor(
    private val repository : UserRepository
) {

    suspend operator fun invoke (): List<UserItem> {
        val user = repository.getAllUsersFromDataBase()
        return user.ifEmpty { emptyList() }

    }
}