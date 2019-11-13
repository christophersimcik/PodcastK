package com.example.chris.podcastk

data class EpisodeResponse(
        val id : String,
        val audio : String,
        val title : String,
        val image : String,
        val thumb : String,
        val descr : String,
        val length : Int,
        val notes : String
)
