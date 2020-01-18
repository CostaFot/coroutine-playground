package com.feelsokman.coroutineplayground.ui.fragments.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.feelsokman.coroutineplayground.R
import com.feelsokman.coroutineplayground.ui.base.BaseFragment
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.PostViewModel
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.PostViewModelFactory
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.State
import kotlinx.android.synthetic.main.fragment_post.*
import javax.inject.Inject

class PostFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    @Inject
    internal lateinit var factory: PostViewModelFactory
    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModelpost by viewModels<PostViewModel>({ this }, { factory })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelpost.stateData.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                State.Loading -> button.text = "Loading"
                is State.Post -> button.text = state.text
            }
        })

        button.setOnClickListener {
            viewModelpost.getRedditPost()
        }
    }
}
