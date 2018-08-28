package rainmtime.com.kotlinrepo.movie.network

import rainmtime.com.demorepo.movies.data.MoviesRsp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by chunyu on 2018/8/27 下午4:10.
 * Email: 746431278@qq.com
 */
interface  MovieNetApi{
  @GET("top250")
  fun getTop250(@Query("start") start:Int,@Query("count") count:Int):Call<MoviesRsp>
}