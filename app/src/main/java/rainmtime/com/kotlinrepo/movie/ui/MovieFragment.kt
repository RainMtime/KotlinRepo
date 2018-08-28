package rainmtime.com.kotlinrepo.movie.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rainmtime.com.demorepo.movies.data.MoviesRsp
import rainmtime.com.kotlinrepo.R
import rainmtime.com.kotlinrepo.movie.adapter.MovieRecyclerViewAdapter
import rainmtime.com.kotlinrepo.movie.network.DouBanNetService
import rainmtime.com.kotlinrepo.utils.CommonUtils
import rainmtime.com.kotlinrepo.utils.ThreadUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by chunyu on 2018/8/27 下午3:37.
 * Email: 746431278@qq.com
 */
class MovieFragment : Fragment() {

    companion object {
        private val TAG = "MovieFragment"
    }

    private var mAdapter: MovieRecyclerViewAdapter? = null

    private var recyclerView: RecyclerView? = null

    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView: View = inflater.inflate(R.layout.fragment_movie, container, false)
        initView(rootView)
        initViewAndAdapter()
        ThreadUtils.post(Runnable { requestData() })
        return rootView

    }

    private fun initView(rootView: View) {
        recyclerView = rootView.findViewById(R.id.recyclerView)
        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefreshLayout)

        swipeRefreshLayout!!.setOnRefreshListener {
            requestData()
            swipeRefreshLayout!!.isRefreshing = false
        }
    }

    private fun initViewAndAdapter() {
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = linearLayoutManager
        mAdapter = MovieRecyclerViewAdapter(context!!)
        recyclerView!!.adapter = mAdapter
    }


    private fun requestData() {
        val call = DouBanNetService.movieNetApi!!.getTop250(0, 249)
        call.enqueue(object : Callback<MoviesRsp> {
            override fun onFailure(call: Call<MoviesRsp>?, t: Throwable?) {
                Log.e(TAG, t?.message)
            }

            override fun onResponse(call: Call<MoviesRsp>?, response: Response<MoviesRsp>?) {
                val resultCode = response?.code()
                val moviesRsp = response?.body()

                Log.i(TAG, "onResponse:" + resultCode
                        + "\n" + moviesRsp?.title)

                if (!CommonUtils.isCollectionEmpty(moviesRsp?.subjects)) {
                    mAdapter!!.setData(moviesRsp!!.subjects)
                }
            }
        })
    }


}