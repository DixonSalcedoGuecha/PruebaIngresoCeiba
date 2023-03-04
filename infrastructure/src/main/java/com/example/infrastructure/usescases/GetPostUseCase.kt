package com.example.infrastructure.usescases

import com.example.infrastructure.repository.PostRepository
import com.example.domain.model.PostItem
import com.example.infrastructure.data.database.entities.toDataBase
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository : PostRepository
) {

    suspend operator fun invoke (id: Int): List<PostItem> {
        var user = repository.getIdUserPostFromDataBase(id)

       return user.ifEmpty {
           user = repository.getIdUserPostFromApi(id)
           repository.insertPost(user.map { it.toDataBase() })
           user
       }

    }
}