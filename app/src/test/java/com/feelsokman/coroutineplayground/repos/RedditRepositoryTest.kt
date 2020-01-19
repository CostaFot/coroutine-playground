package com.feelsokman.coroutineplayground.repos

import com.feelsokman.coroutineplayground.CoroutinesTestRule
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RedditRepositoryTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var redditRepository: RedditRepository

    @Before
    fun setUp() {
        redditRepository = RedditRepository(coroutinesTestRule.testDispatcherProvider)
    }

    @Test
    fun `getPost actually returns the post I am expecting`() {
        coroutinesTestRule.testDispatcher.runBlockingTest {
            // Given
            val expectedPost: State.Post = State.Post("I hope this post gets me karma points")
            // When
            val actualPost: State.Post = redditRepository.getPost()
            // Then
            assertEquals(expectedPost, actualPost)
        }
    }
}
