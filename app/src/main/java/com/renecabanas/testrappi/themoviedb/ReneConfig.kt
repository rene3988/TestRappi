package com.renecabanas.testrappi.themoviedb

/**
 * Created by Rene Cabañas on 16/10/19.
 */
object ReneConfig {
    val API_KEY:String = "3356a9a11b47ac5b40bcd1e26bb9a257" //TODO: API_KEY ambil dari themoviedb.org
    val API_BASE_URL:String = "http://api.themoviedb.org/3"
    val IMG_BASE_URL:String = "http://image.tmdb.org/t/p/w185"
}

/*
Filtering
http://api.themoviedb.org/3/movie/popular?api_key=
http://api.themoviedb.org/3/movie/top_rated?api_key=

Trailer
http://api.themoviedb.org/3/movie/{id}19404/videos?api_key=
Review
http://api.themoviedb.org/3/movie/{id}22/reviews?api_key=
 */