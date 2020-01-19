package com.feelsokman.coroutineplayground.repos

import com.feelsokman.coroutineplayground.CoroutineTestRule
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
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var redditRepository: RedditRepository

    @Before
    fun setUp() {
        redditRepository = RedditRepository(coroutineTestRule.testDispatcherProvider)
    }

    @Test
    fun `getPost actually returns the post I am expecting`() {
        // run the test on the testDispatcher provided by the coroutinesTestRule declared at the top
        coroutineTestRule.testDispatcher.runBlockingTest {
            // Given
            val expectedPost: State.Post = State.Post("I hope this post gets me karma points")
            // When
            val actualPost: State.Post = redditRepository.getPost()
            // Then
            assertEquals(expectedPost, actualPost)
        }
    }
}
