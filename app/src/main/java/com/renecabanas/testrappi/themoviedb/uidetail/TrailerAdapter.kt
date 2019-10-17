package com.renecabanas.testrappi.themoviedb.uimovie

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import com.renecabanas.testrappi.themoviedb.base.BaseAdapter
import com.renecabanas.testrappi.themoviedb.base.BaseViewHolder
import com.renecabanas.testrappi.themoviedb.data.trailer.Trailer
import com.renecabanas.testrappi.R


/**
 * Created by Rene Cabañas on 16/10/19.
 */
class TrailerAdapter : BaseAdapter<Trailer, TrailerAdapter.TrailerViewHolder>() {

    override fun getItemViewId(): Int = R.layout.trailer_item

    override fun instantiateViewHolder(view: View?): TrailerViewHolder = TrailerViewHolder(view)

    class TrailerViewHolder(itemView: View?) : BaseViewHolder<Trailer>(itemView) {

        val container: View by lazy { itemView?.findViewById(R.id.container) as View }
        val name: TextView by lazy { itemView?.findViewById(R.id.name) as TextView }
        val siteAndType: TextView by lazy { itemView?.findViewById(R.id.site_and_type) as TextView }

        override fun onBind(item: Trailer) {
            //name site type
            name.text = item.name
            siteAndType.text = "Trailer type ${item.type} provided by ${item.site}"
            container.setOnClickListener {
                val youtube = "https://www.youtube.com/watch?v=${item.key}"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(youtube)
                it.context.startActivity(intent)
            }
        }
    }

}