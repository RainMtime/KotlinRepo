package rainmtime.com.kotlinrepo.movie.datamodel


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by chunyu on 2018/2/11 下午3:37.
 * Email: 746431278@qq.com
 */
class Subject {
    /**
     * rating : {"max":10,"average":7.8,"stars":"40","min":0}
     * genres : ["动画","短片","动作"]
     * title : 喜剧
     * casts : [{"alt":"https://movie.douban.com/celebrity/1048584/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/27393.jpg","large":"https://img3.doubanio
     * .com/img/celebrity/large/27393.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/27393.jpg"},"name":"绿川光","id":"1048584"},{"alt":"https://movie.douban.com/celebrity/1028508/",
     * "avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1361592268.1.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1361592268.1.jpg","medium":"https://img3.doubanio
     * .com/img/celebrity/medium/1361592268.1.jpg"},"name":"前田爱","id":"1028508"}]
     * collect_count : 3616
     * original_title : 喜劇
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1321065/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/52041.jpg","large":"https://img3.doubanio
     * .com/img/celebrity/large/52041.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/52041.jpg"},"name":"中泽一登","id":"1321065"}]
     * year : 2002
     * images : {"small":"https://img5.doubanio.com/spic/s3823996.jpg","large":"https://img5.doubanio.com/lpic/s3823996.jpg","medium":"https://img5.doubanio.com/mpic/s3823996.jpg"}
     * alt : https://movie.douban.com/subject/3731342/
     * id : 3731342
     */

    @SerializedName("rating")
    @Expose
    var rating: Rating? = null
    @SerializedName("genres")
    @Expose
    var genres: List<String>? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("casts")
    @Expose
    var casts: List<Cast>? = null
    @SerializedName("collect_count")
    @Expose
    var collectCount: Int? = null
    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null
    @SerializedName("subtype")
    @Expose
    var subtype: String? = null
    @SerializedName("directors")
    @Expose
    var directors: List<Director>? = null
    @SerializedName("year")
    @Expose
    var year: String? = null
    @SerializedName("images")
    @Expose
    var images: Images? = null
    @SerializedName("alt")
    @Expose
    var alt: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null

}

