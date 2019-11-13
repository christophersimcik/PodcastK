package com.example.chris.podcastk

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ListenVM : ViewModel() {
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : GenresRepo = GenresRepo(APIfactory.listenApi)


    val genresLiveData = MutableLiveData<MutableList<GenreResponse>>()

    fun fetchGenres(){ scope.launch{
        val g = repository.getGenres()
            genresLiveData.postValue(g)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}
