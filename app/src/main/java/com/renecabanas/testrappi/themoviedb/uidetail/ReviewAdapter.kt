package com.renecabanas.testrappi.themoviedb.uimovie

import android.view.View
import android.widget.TextView
import com.renecabanas.testrappi.R
import com.renecabanas.testrappi.themoviedb.base.BaseAdapter
import com.renecabanas.testrappi.themoviedb.base.BaseViewHolder
import com.renecabanas.testrappi.themoviedb.data.review.Review
/**
 * Created by Rene Cabañas on 16/10/19.
 */
class ReviewAdapter : BaseAdapter<Review, ReviewAdapter.ReviewViewHolder>() {

    override fun getItemViewId(): Int = R.layout.review_item

    override fun instantiateViewHolder(view: View?): ReviewViewHolder = ReviewViewHolder(view)

    class ReviewViewHolder(itemView: View?) : BaseViewHolder<Review>(itemView) {

        val author: TextView by lazy { itemView?.findViewById(R.id.author) as TextView }
        val content: TextView by lazy { itemView?.findViewById(R.id.content) as TextView }

        override fun onBind(item: Review) {
            author.text = item.author
            content.text = item.content
        }
    }

}