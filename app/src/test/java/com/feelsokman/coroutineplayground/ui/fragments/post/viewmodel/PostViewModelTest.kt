package com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.feelsokman.coroutineplayground.CoroutineTestRule
import com.feelsokman.coroutineplayground.LifeCycleTestOwner
import com.feelsokman.coroutineplayground.repos.RedditRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.Verify
import org.amshove.kluent.VerifyNoFurtherInteractions
import org.amshove.kluent.When
import org.amshove.kluent.called
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.amshove.kluent.mock
import org.amshove.kluent.on
import org.amshove.kluent.that
import org.amshove.kluent.was
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class PostViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val stateObserver: Observer<State> = mock()
    private val redditRepository: RedditRepository = mock()

    private lateinit var lifeCycleTestOwner: LifeCycleTestOwner
    private lateinit var postViewModel: PostViewModel

    @Before
    fun setUp() {
        lifeCycleTestOwner = LifeCycleTestOwner()
        lifeCycleTestOwner.onCreate()
        postViewModel = PostViewModel(redditRepository)
        postViewModel.stateData.observe(lifeCycleTestOwner, stateObserver)
    }

    @After
    fun tearDown() {
        lifeCycleTestOwner.onDestroy()
    }

    @Test
    fun `geRedditPost shows loading first then the post after it was successfully fetched`() {
        coroutineTestRule.testDispatcher.runBlockingTest {
            // Given
            lifeCycleTestOwner.onResume()
            val redditPost = State.Post("This is a reddit post")
            When calling redditRepository.getPost() itReturns redditPost
            // When
            postViewModel.getRedditPost()
            // Then
            Verify on stateObserver that stateObserver.onChanged(State.Loading) was called
            Verify on stateObserver that stateObserver.onChanged(redditPost) was called
            VerifyNoFurtherInteractions on stateObserver
        }
    }

    @Test
    fun `geRedditPost gfrgdeg`() {
        coroutineTestRule.testDispatcher.runBlockingTest {
            // Given
            lifeCycleTestOwner.onResume()
            val redditPost = State.Post("This is a reddit post")
            When calling redditRepository.getPost() itReturns redditPost
            // When
            postViewModel.getRedditPost()
            // Then
            Verify on stateObserver that stateObserver.onChanged(State.Loading) was called
            Verify on stateObserver that stateObserver.onChanged(redditPost) was called
            VerifyNoFurtherInteractions on stateObserver
        }
    }
}
