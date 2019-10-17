package com.renecabanas.testrappi.themoviedb.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.renecabanas.testrappi.themoviedb.data.movie.Movie
import com.renecabanas.testrappi.themoviedb.data.movie.MovieDao
import com.renecabanas.testrappi.themoviedb.data.review.Review
import com.renecabanas.testrappi.themoviedb.data.review.ReviewDao
import com.renecabanas.testrappi.themoviedb.data.trailer.Trailer
import com.renecabanas.testrappi.themoviedb.data.trailer.TrailerDao

/**
 * Created by Rene Cabañas on 16/10/19.
 */

@Database(entities = arrayOf(Movie::class, Review::class, Trailer::class), version = 1, exportSchema = false)
abstract class ReneDB : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun reviewDao(): ReviewDao
    abstract fun trailerDao(): TrailerDao

    companion object {
        const val DB_NAME = "movin_db"
    }

}