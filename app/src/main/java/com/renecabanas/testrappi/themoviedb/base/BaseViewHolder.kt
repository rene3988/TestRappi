package com.renecabanas.testrappi.themoviedb.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Rene Cabañas on 16/10/19.
 */
abstract class BaseViewHolder<in D>(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(item: D)
}