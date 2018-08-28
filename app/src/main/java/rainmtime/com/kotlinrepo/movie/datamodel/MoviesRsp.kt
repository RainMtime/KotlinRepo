package rainmtime.com.demorepo.movies.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import rainmtime.com.kotlinrepo.movie.datamodel.Subject


/**
 * Created by chunyu on 2018/2/11 下午3:30.
 * Email: 746431278@qq.com
 */
class MoviesRsp {

    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("start")
    @Expose
    var start: Int? = null
    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("subjects")
    @Expose
    var subjects: List<Subject>? = null
    @SerializedName("title")
    @Expose
    var title: String? = null

}

