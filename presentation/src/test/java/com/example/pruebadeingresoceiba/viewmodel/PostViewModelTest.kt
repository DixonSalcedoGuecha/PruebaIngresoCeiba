package com.example.pruebadeingresoceiba.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.PostItem
import com.example.infrastructure.usescases.GetPostNotConnetctedUseCase
import com.example.infrastructure.usescases.GetPostUseCase
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
internal class PostViewModelTest {

    @RelaxedMockK
    private lateinit var getPostUseCase: GetPostUseCase
    @RelaxedMockK
    private lateinit var getPostNotConnetctedUseCase: GetPostNotConnetctedUseCase

    private lateinit var postViewModel: PostViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        postViewModel = PostViewModel(getPostUseCase,getPostNotConnetctedUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when view model is created at the first time, get all post`() =
        runTest{
            //Given
            val postList = listOf(
                PostItem(1,1, "title for the post", "Body for the post" ),
                PostItem(1,2, "title for the post two", "Body for the post two" )
            )

            coEvery { getPostUseCase(any()) } returns postList

            //When
            postViewModel.onCreate()

            //Then
            assert(getPostUseCase(1) == postList)
        }
}