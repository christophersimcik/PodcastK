package com.example.chris.podcastk

data class PodcastResponse(
        val id : String,
        val title : String,
        val img : String,
        val thumb : String,
        val rss : String,
        val episodes : List<EpisodeResponse>
)