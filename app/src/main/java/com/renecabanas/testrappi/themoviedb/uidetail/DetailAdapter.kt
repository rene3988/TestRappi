package com.renecabanas.testrappi.themoviedb.uimovie

import android.view.View
import android.widget.TextView
import com.renecabanas.testrappi.themoviedb.base.BaseAdapter
import com.renecabanas.testrappi.themoviedb.base.BaseViewHolder
import com.renecabanas.testrappi.themoviedb.data.movie.Movie
import java.text.SimpleDateFormat
import com.renecabanas.testrappi.R

/**
 * Created by Rene Cabañas on 16/10/19.
 */
class DetailAdapter : BaseAdapter<Movie, DetailAdapter.DetailViewHolder>() {

    override fun getItemViewId(): Int = R.layout.movie_detail_item

    override fun instantiateViewHolder(view: View?): DetailViewHolder = DetailViewHolder(view)

    class DetailViewHolder(itemView: View?) : BaseViewHolder<Movie>(itemView) {

        private val readFormat = SimpleDateFormat("yyyy-MM-dd")
        private val writeFormat = SimpleDateFormat("dd MMMM yyyy")

        val movieTitle: TextView by lazy { itemView?.findViewById(R.id.movieTitle) as TextView }
        val movieDate: TextView by lazy { itemView?.findViewById(R.id.movieDate) as TextView }
        val movieOverview: TextView by lazy { itemView?.findViewById(R.id.movieOverview) as TextView }
        val movieRating: TextView by lazy { itemView?.findViewById(R.id.movieRating) as TextView }
        val moviePopularity: TextView by lazy { itemView?.findViewById(R.id.moviePopularity) as TextView }

        override fun onBind(item: Movie) {
            var formatted = item.releaseDate
            if (item.releaseDate != null) {
                formatted = writeFormat.format(readFormat.parse(item.releaseDate))
            }
            movieTitle.text = item.originalTitle
            movieDate.text = "Release date $formatted"
            movieOverview.text = item.overview
            movieRating.text = "\uD83E\uDD47️ Average rating ${item.voteAverage}"
            moviePopularity.text = "✨ Popularity by community ${item.popularity?.toInt()}"
        }
    }

}