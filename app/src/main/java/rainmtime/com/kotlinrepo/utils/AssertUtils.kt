package rainmtime.com.kotlinrepo.utils

/**
 * Created by chunyu on 2018/8/16 上午10:32.
 * Email: 746431278@qq.com
 */
object AssertUtils {

    fun assertTrue(cond: Boolean) {
        if (!cond) {
            throw  AssertionError()
        }
    }

    fun assertTrue(cond: Boolean, msg: String) {
        if (!cond) {
            throw AssertionError(msg)
        }
    }
}