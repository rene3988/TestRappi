package com.renecabanas.testrappi.themoviedb.data.trailer

import io.reactivex.Single

/**
 * Created by Rene Cabañas on 16/10/19.
 */

interface TrailerDS {
    fun getTrailers(id: Long): Single<List<Trailer>>
    fun saveRepositories(id:Long, list: List<Trailer>): Unit = Unit
}