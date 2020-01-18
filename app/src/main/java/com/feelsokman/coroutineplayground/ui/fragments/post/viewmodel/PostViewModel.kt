package com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feelsokman.coroutineplayground.repos.Post
import com.feelsokman.coroutineplayground.repos.RedditRepository
import kotlinx.coroutines.launch

class PostViewModel(private val redditRepository: RedditRepository) : ViewModel() {

    val postData = MutableLiveData<Post>()

    fun getRedditPost() {
        viewModelScope.launch {
            val post: Post = redditRepository.getPost()
            postData.value = post
        }
    }
}
