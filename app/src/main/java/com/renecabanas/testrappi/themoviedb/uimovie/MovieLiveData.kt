package com.renecabanas.testrappi.themoviedb.uimovie

import android.arch.lifecycle.MediatorLiveData
import com.renecabanas.testrappi.themoviedb.data.movie.Movie
import com.renecabanas.testrappi.themoviedb.data.movie.MovieRepository
import com.renecabanas.testrappi.themoviedb.uimovie.MovieVM.Companion.FILTER_FAVORITE
import com.renecabanas.testrappi.themoviedb.uimovie.MovieVM.Companion.FILTER_POPULAR
import com.renecabanas.testrappi.themoviedb.uimovie.MovieVM.Companion.FILTER_TOP_RATED
import io.reactivex.disposables.Disposable

/**
 * Created by Rene Cabañas on 16/10/19.
 */
class MovieLiveData(val repository: MovieRepository)
    : MediatorLiveData<Pair<List<Movie>?, Throwable?>>() {


    private var disposable: Disposable? = null

    var filter: String? = null
        set(value) {
            value?.let {
                when (it) {
                    FILTER_POPULAR -> disposable = repository
                            .getPopular()
                            .subscribe { data, error -> this@MovieLiveData.value = Pair(data, error) }
                    FILTER_TOP_RATED -> disposable = repository
                            .getTopRated()
                            .subscribe { data, error -> this@MovieLiveData.value = Pair(data, error) }
                    FILTER_FAVORITE -> disposable = repository
                            .getFavorite()
                            .subscribe { data, error -> this@MovieLiveData.value = Pair(data, error) }
                }
            }
        }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}