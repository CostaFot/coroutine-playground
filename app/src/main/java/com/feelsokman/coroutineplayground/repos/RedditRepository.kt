package com.feelsokman.coroutineplayground.repos

import com.feelsokman.coroutineplayground.coroutine.DispatcherProvider
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RedditRepository(private val dispatcherProvider: DispatcherProvider) {

    suspend fun getPost(): State.Post {
        return withContext(dispatcherProvider.io) {
            delay(2000)
            State.Post("🐢 SLOW AND STEADY 🐢 WINS THE RACE 🐢 MODS CAN'T BAN ME 🐢 AT THIS PACE 🐢")
        }
    }
}
