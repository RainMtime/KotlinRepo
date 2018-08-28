package rainmtime.com.kotlinrepo.movie.datamodel

/**
 * Created by chunyu on 2018/2/11 下午3:40.
 * Email: 746431278@qq.com
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Avatars {

    @SerializedName("small")
    @Expose
    var small: String? = null
    @SerializedName("large")
    @Expose
    var large: String? = null
    @SerializedName("medium")
    @Expose
    var medium: String? = null

}
