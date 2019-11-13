package com.example.chris.podcastk

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.ViewModelStoreOwner
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chris.podcastk.R.id.recyclerView
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.Observer

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: GenreAdapter
    private lateinit var listenVM: ListenVM
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        linearLayoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = linearLayoutManager
        adapter = GenreAdapter()
        recyclerView.adapter = adapter
        listenVM = ViewModelProviders.of(this).get(listenVM::class.java)
        listenVM.fetchGenres()
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}
