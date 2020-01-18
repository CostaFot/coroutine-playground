package com.feelsokman.coroutineplayground.ui.fragments.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.feelsokman.coroutineplayground.R
import com.feelsokman.coroutineplayground.ui.activity.viewmodel.MainViewModel
import com.feelsokman.coroutineplayground.ui.base.BaseFragment
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.PostViewModel
import com.feelsokman.coroutineplayground.ui.fragments.post.viewmodel.PostViewModelFactory
import kotlinx.android.synthetic.main.fragment_post.*
import timber.log.Timber
import javax.inject.Inject

class PostFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    @Inject
    internal lateinit var factory: PostViewModelFactory
    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModelHost by viewModels<PostViewModel>({ this }, { factory })
    // Get a reference to the ViewModel scoped to its Activity
    private val activityViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel.textData.observe(viewLifecycleOwner, Observer {
            Timber.tag("NavigationLogger").e("HostFragment Activity string is $it")
        })

        viewModelHost.postData.observe(viewLifecycleOwner, Observer { post ->
            button.text = post.text
        })

        button.setOnClickListener {
            viewModelHost.getRedditPost()
        }
    }
}
