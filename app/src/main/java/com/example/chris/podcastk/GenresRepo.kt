package com.example.chris.podcastk

 class GenresRepo(private val api : ListenAPI) : BaseRepo() {
    suspend fun getGenres() : MutableList<GenreResponse>?{

        //safeApiCall is defined in BaseRepository.kt (https://gist.github.com/navi25/67176730f5595b3f1fb5095062a92f15)

        val genresResponse = safeApiCall(
                call = {api.getGenres().await()},
                errorMessage = "Error Retrieving Genres"
        )

        return genresResponse?.results?.toMutableList();

    }
}