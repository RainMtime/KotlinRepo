package rainmtime.com.kotlinrepo.utils

import rainmtime.com.kotlinrepo.global.GlobalContext

/**
 * Created by chunyu on 2018/8/27 上午11:24.
 * Email: 746431278@qq.com
 */
object DisplayMetricsUtils {

    private var sDensity = 0.0f
        get() {
            if (sDensity - 0 <= 1e-6) {
                sDensity = GlobalContext.Companion.get().application.resources.displayMetrics.density
            }
            return sDensity
        }

    fun dip2px(dipValue: Float): Int {
        return (dipValue * sDensity + 0.5f).toInt()
    }
}