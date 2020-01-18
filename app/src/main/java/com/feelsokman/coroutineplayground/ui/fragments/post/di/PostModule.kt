package com.feelsokman.coroutineplayground.ui.fragments.post.di

import com.feelsokman.coroutineplayground.repos.RedditRepository
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.PostViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PostModule {

    @Provides
    internal fun providesPostViewModelFactory(redditRepository: RedditRepository) =
        PostViewModelFactory(redditRepository)
}
