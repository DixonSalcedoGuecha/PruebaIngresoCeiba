package com.example.infrastructure.usescases

import com.example.infrastructure.repository.PostRepository
import com.example.domain.model.PostItem
import javax.inject.Inject

class GetPostNotConnetctedUseCase @Inject constructor(
    private val repository : PostRepository
) {

    suspend operator fun invoke (id: Int): List<PostItem> {
        val user = repository.getIdUserPostFromDataBase(id)

       return user.ifEmpty {
           emptyList()
       }

    }
}