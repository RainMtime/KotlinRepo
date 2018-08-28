package rainmtime.com.kotlinrepo.movie.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by chunyu on 2018/8/27 下午4:03.
 * Email: 746431278@qq.com
 */
object DouBanNetService {

    val movieNetApi: MovieNetApi? = Retrofit.Builder()
            .baseUrl("https://api.douban.com/v2/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieNetApi::class.java)

}