package com.renecabanas.testrappi.themoviedb.uimovie

import android.content.Intent
import android.view.View
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.renecabanas.testrappi.R
import com.renecabanas.testrappi.themoviedb.ReneConfig
import com.renecabanas.testrappi.themoviedb.base.BaseAdapter
import com.renecabanas.testrappi.themoviedb.base.BaseViewHolder
import com.renecabanas.testrappi.themoviedb.data.movie.Movie
import java.text.SimpleDateFormat

/**
 * Created by Rene Cabañas on 16/10/19.
 */
class MovieAdapter : BaseAdapter<Movie, MovieAdapter.ReposViewHolder>() {

    var movie:Movie?=null

    override fun getItemViewId(): Int = R.layout.movie_item

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<Movie>(itemView) {

        private val readFormat = SimpleDateFormat("yyyy-MM-dd")
        private val writeFormat = SimpleDateFormat("dd MMMM yyyy")

        val movieTitle: TextView by lazy { itemView?.findViewById(R.id.movieTitle) as TextView }
        val movieDate: TextView by lazy { itemView?.findViewById(R.id.movieDate) as TextView }
        val movieOverview: TextView by lazy { itemView?.findViewById(R.id.movieOverview) as TextView }
        val movieRating: TextView by lazy { itemView?.findViewById(R.id.movieRating) as TextView }
        val moviePopularity: TextView by lazy { itemView?.findViewById(R.id.moviePopularity) as TextView }
        val moviePoster: SimpleDraweeView by lazy { itemView?.findViewById(R.id.moviePoster) as SimpleDraweeView }

        override fun onBind(item: Movie) {
            var formatted = item.releaseDate
            if (item.releaseDate != null) {
                formatted = writeFormat.format(readFormat.parse(item.releaseDate))
            }
            movieTitle.text = item.originalTitle
            movieDate.text = "Release $formatted"
            movieOverview.text = item.overview
            movieRating.text = "️\uD83E\uDD47 Rating ${item.voteAverage}"
            moviePopularity.text = "✨ Popular ${item.popularity?.toInt()}"
            moviePoster.setImageURI("${ReneConfig.IMG_BASE_URL}${item.posterPath}")
            moviePoster.setOnClickListener {
                val detail = Intent(it.context, DetailActivity::class.java)
                detail.putExtra("extra", item.id)
                it.context.startActivity(detail)
            }
        }
    }

}
