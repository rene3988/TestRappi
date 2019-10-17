package com.renecabanas.testrappi.themoviedb.uimovie

import android.arch.lifecycle.MediatorLiveData
import com.renecabanas.testrappi.themoviedb.data.trailer.Trailer
import com.renecabanas.testrappi.themoviedb.data.trailer.TrailerRepository
import io.reactivex.disposables.Disposable

/**
 * Created by Rene Cabañas on 16/10/19.
 */

class TrailerLiveData : MediatorLiveData<Pair<List<Trailer>?, Throwable?>>() {


    val repo = TrailerRepository()

    var movieId: Long? = null
        set(value) {
            value?.let {
                disposable = repo.getTrailers(it).subscribe { data, error -> this@TrailerLiveData.value = Pair(data, error) }
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