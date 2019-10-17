package com.renecabanas.testrappi.themoviedb.data.review

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.renecabanas.testrappi.themoviedb.ext.getResultJson

/**
 * Created by Rene Cabañas on 16/10/19.
 */

@Entity(tableName = "reviews")
class Review {
    @PrimaryKey
    var id: String? = null
    var movieId: Long? = null
    var author: String? = null
    var content: String? = null

    class ListDeserializer : ResponseDeserializable<List<Review>> {
        override fun deserialize(content: String): List<Review> =
                Gson().fromJson<List<Review>>(content.getResultJson(), object : TypeToken<List<Review>>() {}.type)
    }
}