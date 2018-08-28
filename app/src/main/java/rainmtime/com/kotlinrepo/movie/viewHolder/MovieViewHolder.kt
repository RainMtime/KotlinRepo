package rainmtime.com.kotlinrepo.movie.viewHolder

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import rainmtime.com.kotlinrepo.R
import rainmtime.com.kotlinrepo.movie.datamodel.Subject
import rainmtime.com.kotlinrepo.utils.ResUtils

/**
 * Created by chunyu on 2018/8/27 下午5:26.
 * Email: 746431278@qq.com
 */
class MovieViewHolder(itemView: View, private val mContext: Context) : RecyclerView.ViewHolder(itemView) {


    var llItem: LinearLayout? = itemView.findViewById(R.id.ll_item)
    var imgMovie: ImageView? = itemView.findViewById(R.id.img_movie)
    var tvMovieTitle: TextView? = itemView.findViewById(R.id.tv_movie_title)
    var tvMovieDirector: TextView? = itemView.findViewById(R.id.tv_movie_director)
    var tvMovieCast: TextView? = itemView.findViewById(R.id.tv_movie_cast)
    var tvMovieAverage: TextView? = itemView.findViewById(R.id.tv_movie_average)


    fun renderView(subject: Subject?) {

        Glide.with(mContext).load(subject?.images?.medium).into(imgMovie!!)
        tvMovieTitle!!.text = subject?.title

        var directors = ""
        if (subject?.directors != null) {
            for (i in 0 until subject.directors!!.size) {
                val director = subject.directors!![i]
                directors += if (i == subject.directors!!.size - 1) {
                    director.name
                } else {
                    director.name + ", "
                }
            }
        } else {
            directors = ResUtils.getString(R.string.unknown)
        }

        tvMovieDirector!!.text = ResUtils.getString(R.string.director, directors)

        //设置主演
        var casts = ""
        if (subject?.casts != null) {
              for (i in 0 until subject.casts!!.size){
                  val  cats = subject.casts!![i]
                  casts += if (i == subject.casts!!.size -1){
                      cats.name
                  }else{
                      cats.name + ",  "
                  }
              }
        }else{
            casts = ResUtils.getString(R.string.unknown)
        }

        tvMovieCast!!.text = ResUtils.getString(R.string.cast,casts)

        //设置分数
        tvMovieAverage!!.text = ResUtils.getString(R.string.average,"" + subject?.rating?.average)

        //点击回调
        itemView.setOnClickListener {v ->
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

}