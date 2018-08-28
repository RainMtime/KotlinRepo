package rainmtime.com.kotlinrepo.movie.datamodel

/**
 * Created by chunyu on 2018/2/11 下午3:39.
 * Email: 746431278@qq.com
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Director {

    @SerializedName("alt")
    @Expose
    var alt: String? = null
    @SerializedName("avatars")
    @Expose
    var avatars: DirectorAvatar? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null

}