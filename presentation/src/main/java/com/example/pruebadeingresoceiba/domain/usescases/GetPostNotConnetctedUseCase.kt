package com.example.pruebadeingresoceiba.domain.usescases

import com.example.pruebadeingresoceiba.data.PostRepository
import com.example.pruebadeingresoceiba.domain.model.PostItem
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