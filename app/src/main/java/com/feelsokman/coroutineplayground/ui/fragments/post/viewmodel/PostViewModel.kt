package com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feelsokman.coroutineplayground.repos.RedditRepository
import kotlinx.coroutines.launch

class PostViewModel(private val redditRepository: RedditRepository) : ViewModel() {

    val stateData = MutableLiveData<State>()

    fun getRedditPost() {
        viewModelScope.launch {
            stateData.value = State.Loading
            val post: State.Post = redditRepository.getPost()
            stateData.value = post
        }
    }
}

sealed class State {
    object Loading : State()
    data class Post(val text: String) : State()
}
