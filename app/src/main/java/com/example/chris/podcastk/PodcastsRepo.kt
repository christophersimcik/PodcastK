package com.example.chris.podcastk

class PodcastsRepo(private val api : ListenAPI, private val id : Int) : BaseRepo() {
    suspend fun getPodcasts() : MutableList<PodcastResponse>?{



        val podcastResponse = safeApiCall(
                call = {api.getBestOfGenre(id).await()},
                errorMessage = "Error Retrieving Podcasts"
        )

        return podcastResponse?.results?.toMutableList();

    }
}