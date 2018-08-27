package rainmtime.com.kotlinrepo.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by chunyu on 2018/8/27 下午2:48.
 * Email: 746431278@qq.com
 */
object TimeUtils{
    val DEFAULT_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val FEED_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val SERVER_DATE_FORMAT = SimpleDateFormat("yyyyMMddHHmm")
    val EXIF_DATE_FORMAT = SimpleDateFormat("yyyy:MM:dd HH:mm:ss")

    //    public static String formatFeedDate(Date date) {
    //        return FEED_DATE_FORMAT.format(date);
    //    }

    private val sStringBuilder = StringBuilder(32)

    fun calcTimeCost(st: Long): Long {
        return System.currentTimeMillis() - st
    }

    //* 今天+时间（24小时制），如“今天07:55”
    //* 昨天/前天+时间，如“昨天07:30”
    //* 日期+时间，如“06-16 04:23”
    fun formatMessageDateTime2(dateTimeMillis: Long): String {
        val currentMillis = System.currentTimeMillis()
        //以目标时间的天数和当前时间的天数差为衡量标准
        //需要格式化的日历
        val c = Calendar.getInstance()
        c.timeInMillis = dateTimeMillis
        val d = c.get(Calendar.DAY_OF_MONTH)
        val h = c.get(Calendar.HOUR_OF_DAY)
        val m = c.get(Calendar.MINUTE)
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_YEAR)

        //当前日历
        val c2 = Calendar.getInstance()
        c2.timeInMillis = currentMillis
        val year2 = c2.get(Calendar.YEAR)
        val day2 = c2.get(Calendar.DAY_OF_YEAR)

        val diffDay: Int
        //计算天数差
        if (year2 != year) { //不同年份
            var timeDistance = 0
            for (i in year until year2) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //闰年
                    timeDistance += 366
                } else {  //不是闰年
                    timeDistance += 365
                }
            }
            diffDay = timeDistance + (day2 - day)
        } else { //同一年
            diffDay = day2 - day
        }

        sStringBuilder.delete(0, sStringBuilder.length)
        return if (diffDay == 0) {
            sStringBuilder.append("今天").append(if (h < 10) "0$h" else h).append(":").append(if (m < 10) "0$m" else m).toString()
        } else if (diffDay == 1) {//显示昨天
            sStringBuilder.append("昨天").append(if (h < 10) "0$h" else h).append(":").append(if (m < 10) "0$m" else m).toString()
        } else if (diffDay == 2) {//显示前天
            sStringBuilder.append("前天").append(if (h < 10) "0$h" else h).append(":").append(if (m < 10) "0$m" else m).toString()
        } else {//显示日期
            if (year2 != year) {//不同年
                sStringBuilder.append(year).append("-").append(if (month < 10) "0$month" else month).append("-").append(if (d < 10) "0$d" else d).append(" ").append(if (h < 10) "0$h" else h).append(":").append(if (m < 10) "0$m" else m).toString()
            } else {//同年
                sStringBuilder.append(if (month < 10) "0$month" else month).append("-").append(if (d < 10) "0$d" else d).append(" ").append(if (h < 10) "0$h" else h).append(":").append(if (m < 10) "0$m" else m).toString()
            }
        }
    }
}