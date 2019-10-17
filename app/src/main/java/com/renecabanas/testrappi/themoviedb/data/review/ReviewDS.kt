package com.renecabanas.testrappi.themoviedb.data.review

import io.reactivex.Single

/**
 * Created by Rene Cabañas on 16/10/19.
 */

interface ReviewDS {
    fun getReviews(id: Long): Single<List<Review>>
    fun saveRepositories(id:Long, list: List<Review>): Unit = Unit
}