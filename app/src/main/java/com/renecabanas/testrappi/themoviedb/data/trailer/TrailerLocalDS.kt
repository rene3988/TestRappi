package com.renecabanas.testrappi.themoviedb.data.trailer

import com.renecabanas.testrappi.themoviedb.data.DBMaker
import com.renecabanas.testrappi.themoviedb.ext.mapInPlace
import io.reactivex.Single

/**
 * Created by Rene Cabañas on 16/10/19.
 */

class TrailerLocalDS : TrailerDS {
    val dao = DBMaker.db.trailerDao()

    override fun getTrailers(id: Long): Single<List<Trailer>> =
            dao.loadTrailers(id).firstOrError().doOnSuccess { if (it.isEmpty()) throw Exception() }

    override fun saveRepositories(id: Long, list: List<Trailer>) {
        val mutableList = list.toMutableList()
        mutableList.mapInPlace { it.apply{movieId = id} }
        dao.insertAll(mutableList)
    }
}