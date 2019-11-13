package com.example.chris.podcastk

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ListenAPI {
    @GET("genres")
    fun getGenres() : Deferred<Response<GenresResponse>>
    @GET("best_podcasts?genre_id={id}")
    fun getBestOfGenre(@Path("id") id:Int) : Deferred<Response<PodcastsResponse>>

}