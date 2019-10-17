package com.renecabanas.testrappi.themoviedb.data.trailer

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.renecabanas.testrappi.themoviedb.ext.getResultJson

/**
 * Created by Rene Cabañas on 16/10/19.
 */

@Entity(tableName = "trailers")
class Trailer {
    @PrimaryKey
    var id: String? = null
    var movieId: Long? = null
    var key: String? = null
    var name: String? = null
    var site: String? = null
    var type: String? = null

    class ListDeserializer : ResponseDeserializable<List<Trailer>> {
        override fun deserialize(content: String): List<Trailer> =
                Gson().fromJson<List<Trailer>>(content.getResultJson(), object : TypeToken<List<Trailer>>() {}.type)
    }
}