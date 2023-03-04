package com.example.pruebadeingresoceiba.domain

import com.example.pruebadeingresoceiba.data.UserRepository
import com.example.pruebadeingresoceiba.domain.usescases.GetUsersUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetUsersUseCaseTest {

    @RelaxedMockK
    private lateinit var userRepository: UserRepository

    lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getUsersUseCase = GetUsersUseCase(userRepository)
    }

    @Test
    fun `when the data base doesnt return any thing then get values from api`() = runBlocking {
        //Given
        coEvery { userRepository.getAllUsersFromDataBase() } returns emptyList()

        //When
        getUsersUseCase()

        //Then
        coVerify(exactly = 1) {userRepository.getAllUsersFromApi() }
        coVerify(exactly = 1) {userRepository.insertUser(any())  }


    }
}