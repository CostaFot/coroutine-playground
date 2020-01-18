package com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.feelsokman.coroutineplayground.repos.RedditRepository

class PostViewModelFactory(private val redditRepo: RedditRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")

        return PostViewModel(redditRepo) as T
    }
}
