package com.feelsokman.coroutineplayground.ui.fragments.host

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
import com.feelsokman.coroutineplayground.ui.fragments.host.viewmodel.HostViewModel
import com.feelsokman.coroutineplayground.ui.fragments.host.viewmodel.HostViewModelFactory
import kotlinx.android.synthetic.main.fragment_host.*
import timber.log.Timber
import javax.inject.Inject

class HostFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    @Inject
    internal lateinit var factory: HostViewModelFactory
    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModelHost by viewModels<HostViewModel>({ this }, { factory })
    // Get a reference to the ViewModel scoped to its Activity
    private val activityViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel.textData.observe(viewLifecycleOwner, Observer {
            Timber.tag("NavigationLogger").e("HostFragment Activity string is $it")
        })

        viewModelHost.textData.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank()) {
                button.text = it
            }
        })

        button.setOnClickListener {
            viewModelHost.getTodos()
        }
    }
}
