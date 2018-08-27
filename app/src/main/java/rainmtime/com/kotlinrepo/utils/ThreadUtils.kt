package rainmtime.com.kotlinrepo.utils

import android.os.Handler
import android.os.Looper

/**
 * Created by chunyu on 2018/8/27 下午2:41.
 * Email: 746431278@qq.com
 */
object ThreadUtils {


    private val sMainThread = Looper.getMainLooper().thread
    private val sMainHandle = Handler(Looper.getMainLooper())

    val isMainThread: Boolean
        get() = sMainThread === Thread.currentThread()

    fun post(runnable: Runnable) {
        sMainHandle.post(runnable)
    }

    fun postDelay(runnable: Runnable, delayMillis: Long) {
        sMainHandle.postDelayed(runnable, delayMillis)
    }

    fun removeCallbacks(runnable: Runnable) {
        sMainHandle.removeCallbacks(runnable)
    }

    fun runOnUiThread(runnable: Runnable) {
        if (isMainThread) {
            runnable.run()
        } else {
            post(runnable)
        }
    }
}