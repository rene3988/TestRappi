package com.renecabanas.testrappi.themoviedb.uimovie

import android.arch.lifecycle.MediatorLiveData
import com.renecabanas.testrappi.themoviedb.data.review.Review
import com.renecabanas.testrappi.themoviedb.data.review.ReviewRepository
import io.reactivex.disposables.Disposable

/**
 * Created by Rene Cabañas on 16/10/19.
 */

class ReviewLiveData : MediatorLiveData<Pair<List<Review>?, Throwable?>>() {


    val movieRepo = ReviewRepository()

    var movieId: Long? = null
        set(value) {
            value?.let {
                disposable = movieRepo.getReviews(it).subscribe { data, error -> this@ReviewLiveData.value = Pair(data, error) }
            }
        }
    private var disposable: Disposable? = null


    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}