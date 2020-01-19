package com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel

import com.feelsokman.coroutineplayground.CoroutineTestRule
import com.feelsokman.coroutineplayground.repos.RedditRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.amshove.kluent.mock
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PostViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private val redditRepository: RedditRepository = mock()

    private lateinit var postViewModel: PostViewModel

    @Before
    fun setUp() {
        postViewModel = PostViewModel(redditRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getRedditPost() {
        coroutineTestRule.testDispatcher.runBlockingTest {
            When calling redditRepository.getPost() itReturns State.Post("dff")
            postViewModel.getRedditPost()
        }
    }
}
