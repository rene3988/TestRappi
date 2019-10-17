package com.renecabanas.testrappi.themoviedb.data.movie


import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.rx.rx_object
import com.renecabanas.testrappi.themoviedb.ReneConfig
import com.renecabanas.testrappi.themoviedb.ext.log
import io.reactivex.Single

/**
 * Created by Rene Cabañas on 16/10/19.
 */

class MovieRemoteDS : MovieDS {

    init {
        FuelManager.instance.basePath = ReneConfig.API_BASE_URL
        FuelManager.instance.baseParams = listOf("api_key" to ReneConfig.API_KEY)
    }

    override fun getPopular(): Single<List<Movie>> = "/movie/popular"
            .httpGet().log().rx_object(Movie.ListDeserializer())
            .map { it?.component1() ?: throw it?.component2() ?: throw Exception() }

    override fun getTopRated(): Single<List<Movie>> = "/movie/top_rated"
            .httpGet().log().rx_object(Movie.ListDeserializer())
            .map { it?.component1() ?: throw it?.component2() ?: throw Exception() }
}