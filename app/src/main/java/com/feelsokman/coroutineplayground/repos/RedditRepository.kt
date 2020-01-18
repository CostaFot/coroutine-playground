package com.feelsokman.coroutineplayground.repos

import com.feelsokman.coroutineplayground.coroutine.DispatcherProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RedditRepository(private val dispatcherProvider: DispatcherProvider) {

    suspend fun getPost(): Post {
        return withContext(dispatcherProvider.io) {
            delay(5000)
            Post("to be fair")
        }
    }
}
