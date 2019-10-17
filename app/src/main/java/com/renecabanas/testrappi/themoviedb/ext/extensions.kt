package com.renecabanas.testrappi.themoviedb.ext

import android.util.Log
import com.github.kittinunf.fuel.core.Request
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject

/**
 * Created by Rene Cabañas on 16/10/19.
 */

fun Request.log(): Request {
    response { request, _, _ -> Log.d("HTTP", request.toString()) }
    return this
}

inline fun <T> MutableList<T>.mapInPlace(mutator: (T) -> T) {
    val iterate = this.listIterator()
    while (iterate.hasNext()) {
        val oldValue = iterate.next()
        val newValue = mutator(oldValue)
        if (newValue !== oldValue) {
            iterate.set(newValue)
        }
    }
}

fun String.getResultJson(): JsonArray {
    val json = Gson().fromJson(this, JsonObject::class.java)
    return json.get("results").asJsonArray
}