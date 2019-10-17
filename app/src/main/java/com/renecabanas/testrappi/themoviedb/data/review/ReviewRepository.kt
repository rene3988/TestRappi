package com.renecabanas.testrappi.themoviedb.data.review

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rene Cabañas on 16/10/19.
 */

class ReviewRepository : ReviewDS {

    private val localDS = ReviewLocalDS()
    private val remoteDS = ReviewRemoteDS()

    override fun getReviews(id: Long): Single<List<Review>> = localDS.getReviews(id)
            .onErrorResumeNext {
                remoteDS.getReviews(id)
                        .doOnSuccess { localDS.saveRepositories(id, it) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}