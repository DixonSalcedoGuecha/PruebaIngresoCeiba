package com.example.infrastructure.usescases

import com.example.infrastructure.repository.PostRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetPostUseCaseTest {

    @RelaxedMockK
    private lateinit var postRepository: PostRepository

    lateinit var getPostUseCase: GetPostUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getPostUseCase = GetPostUseCase(postRepository)
    }

    @Test
    fun `when the data base doesnt return any thing then get values from api`() = runBlocking {
        //Given
        coEvery { postRepository.getIdUserPostFromDataBase(1) } returns emptyList()

        //When
        getPostUseCase(1)

        //Then
        coVerify(exactly = 1) { postRepository.getIdUserPostFromApi(1) }
        coVerify(exactly = 1) { postRepository.insertPost(any()) }


    }
}
