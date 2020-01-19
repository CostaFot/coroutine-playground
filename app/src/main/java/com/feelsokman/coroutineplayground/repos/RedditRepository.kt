package com.feelsokman.coroutineplayground.repos

import com.feelsokman.coroutineplayground.coroutine.DispatcherProvider
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.State
import kotlinx.coroutines.withContext

class RedditRepository(private val dispatcherProvider: DispatcherProvider) {

    suspend fun getPost(): State.Post {
        return withContext(dispatcherProvider.io) {
            // ...imaginary operation that will take a while
            // ..
            State.Post("I hope this post gets me karma points") // return on completion
        }
    }
}
