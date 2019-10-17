package com.renecabanas.testrappi.themoviedb.data.movie

import io.reactivex.Single

/**
 * Created by Rene Cabañas on 16/10/19.
 */

interface MovieDS {

    fun getPopular(): Single<List<Movie>>
    fun getTopRated(): Single<List<Movie>>

    fun saveRepositories(list: List<Movie>) : Unit = Unit

}