package rainmtime.com.kotlinrepo.movie.datamodel

/**
 * Created by chunyu on 2018/2/11 下午3:39.
 * Email: 746431278@qq.com
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cast {

    /**
     * alt : https://movie.douban.com/celebrity/1048584/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/27393.jpg","large":"https://img3.doubanio.com/img/celebrity/large/27393.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/27393.jpg"}
     * name : 绿川光
     * id : 1048584
     */

    @SerializedName("alt")
    @Expose
    var alt: String? = null
    @SerializedName("avatars")
    @Expose
    var avatars: Avatars? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null

}
