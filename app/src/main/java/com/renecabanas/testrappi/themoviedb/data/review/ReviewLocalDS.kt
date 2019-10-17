package com.renecabanas.testrappi.themoviedb.data.review

import com.renecabanas.testrappi.themoviedb.data.DBMaker
import com.renecabanas.testrappi.themoviedb.ext.mapInPlace
import io.reactivex.Single

/**
 * Created by Rene Cabañas on 16/10/19.
 */

class ReviewLocalDS : ReviewDS {
    val dao = DBMaker.db.reviewDao()

    override fun getReviews(id: Long): Single<List<Review>> =
            dao.loadReviews(id).firstOrError().doOnSuccess { if (it.isEmpty()) throw Exception() }

    override fun saveRepositories(id: Long, list: List<Review>) {
        val mutableList = list.toMutableList()
        mutableList.mapInPlace { it.apply { movieId = id } }
        dao.insertAll(mutableList)
    }
}