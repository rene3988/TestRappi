package com.renecabanas.testrappi.themoviedb

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.renecabanas.testrappi.themoviedb.data.DBMaker

/**
 * Created by Rene Cabañas on 16/10/19.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DBMaker.createDb(this)
        Fresco.initialize(this)
    }
}
