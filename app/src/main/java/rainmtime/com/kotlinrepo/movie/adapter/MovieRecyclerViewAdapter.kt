package rainmtime.com.kotlinrepo.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import rainmtime.com.kotlinrepo.R
import rainmtime.com.kotlinrepo.common.BaseRecyclerViewAdapter
import rainmtime.com.kotlinrepo.movie.datamodel.Subject
import rainmtime.com.kotlinrepo.movie.viewHolder.MovieViewHolder

/**
 * Created by chunyu on 2018/8/27 下午5:24.
 * Email: 746431278@qq.com
 */
class MovieRecyclerViewAdapter(context: Context):BaseRecyclerViewAdapter<Subject,MovieViewHolder>(context){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false),context)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        val subject = getItemData(position)
        viewHolder.renderView(subject)
    }
}