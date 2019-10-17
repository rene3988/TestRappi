package com.renecabanas.testrappi.themoviedb.uimovie

import android.arch.lifecycle.MediatorLiveData
import com.renecabanas.testrappi.themoviedb.data.movie.Movie
import com.renecabanas.testrappi.themoviedb.data.movie.MovieRepository
import io.reactivex.disposables.Disposable
/**
 * Created by Rene Cabañas on 16/10/19.
 */

class DetailLiveData : MediatorLiveData<Pair<List<Movie>?, Throwable?>>() {


    val movieRepo = MovieRepository()
    var movieId: Long? = null
        set(value) {
            value?.let {
                disposable = movieRepo.getById(it).subscribe { data, error -> this@DetailLiveData.value = Pair(data, error) }
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