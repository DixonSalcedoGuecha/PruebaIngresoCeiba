package com.example.pruebadeingresoceiba.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pruebadeingresoceiba.domain.GetUsersUseCase
import com.example.pruebadeingresoceiba.domain.model.PostItem
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class UsersViewModelTest {

    @RelaxedMockK
    private lateinit var getUsersUseCase: GetUsersUseCase

    private lateinit var usersViewModel: UsersViewModel

    @get:Rule
    var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        usersViewModel = UsersViewModel(getUsersUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when view model is created at the first time, get all users`() =
        runTest{
        //Given
        val usersList = listOf(PostItem(1,"Dixon", "dixon@gmail.co", "322 554 848 1" ),
                           PostItem(2,"Cristian", "cristian@gmail.co", "312 554 848 1" ))

        coEvery { getUsersUseCase() } returns usersList

        //When
        usersViewModel.onCreate()

        //Then
        assert(usersViewModel.usersList.value == usersList.map { it })
    }
}