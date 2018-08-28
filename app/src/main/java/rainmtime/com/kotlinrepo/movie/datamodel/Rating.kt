package rainmtime.com.kotlinrepo.movie.datamodel


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by chunyu on 2018/2/11 下午3:37.
 * Email: 746431278@qq.com
 */
class Rating {

    @SerializedName("max")
    @Expose
    var max: Int? = null
    @SerializedName("average")
    @Expose
    var average: Double? = null
    @SerializedName("stars")
    @Expose
    var stars: String? = null
    @SerializedName("min")
    @Expose
    var min: Int? = null

}