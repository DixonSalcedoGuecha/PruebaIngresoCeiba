package com.example.pruebadeingresoceiba.domain.usescases

import com.example.pruebadeingresoceiba.data.PostRepository
import com.example.pruebadeingresoceiba.data.database.entities.toDataBase
import com.example.pruebadeingresoceiba.domain.model.PostItem
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