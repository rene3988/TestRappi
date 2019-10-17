package com.renecabanas.testrappi.themoviedb.uimovie

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.renecabanas.testrappi.themoviedb.data.movie.Movie
import com.renecabanas.testrappi.themoviedb.data.movie.MovieRepository

/**
 * Created by Rene Cabañas on 16/10/19.
 */
class MovieVM(application: Application?) : AndroidViewModel(application) {

    private val repository = MovieRepository()

    private val filterLiveData = MutableLiveData<String>()

    val resultLiveData = MovieLiveData(repository)
    val isLoadingLiveData = MediatorLiveData<Boolean>()
    val throwableLiveData = MediatorLiveData<Throwable>()
    val reposLiveData = MediatorLiveData<List<Movie>>()

    init {
        resultLiveData.addSource(filterLiveData) {
            it?.let { resultLiveData.filter = it }
        }
        isLoadingLiveData.addSource(resultLiveData) {
            isLoadingLiveData.value = false
        }
        throwableLiveData.addSource(resultLiveData) {
            it?.second?.let { throwableLiveData.value = it }
        }
        reposLiveData.addSource(resultLiveData) {
            it?.first?.let { reposLiveData.value = it }
        }
    }

    fun setFilter(filterName: String) {
        filterLiveData.value = filterName
        isLoadingLiveData.value = true
    }

    companion object {
        val FILTER_POPULAR = "Popular"
        val FILTER_TOP_RATED = "Top Rated"
        val FILTER_FAVORITE = "Favorites"
    }

}