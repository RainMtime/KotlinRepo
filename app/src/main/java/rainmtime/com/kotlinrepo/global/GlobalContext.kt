package rainmtime.com.kotlinrepo.global

import android.app.Application
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import rainmtime.com.kotlinrepo.utils.AssertUtils
import java.util.concurrent.atomic.AtomicReference

/**
 * Created by chunyu on 2018/8/16 上午10:08.
 * Email: 746431278@qq.com
 */
class GlobalContext(val application:Application){

    val resources:Resources
       get() = application.resources

    val defaultGlobalSharedPreferences:SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(application)

    companion object {
        private val sInstance: AtomicReference<GlobalContext> = AtomicReference<GlobalContext>()

        private val TAG = "GlobalContext"
        fun get():GlobalContext{
            val globalContext = sInstance.get()
            AssertUtils.assertTrue(globalContext !=null,"Global not set")
            return globalContext
        }

        fun set(globalContext: GlobalContext?){
            AssertUtils.assertTrue(globalContext != null,"Invalid context")
            if (!sInstance.compareAndSet(null,globalContext)){
                throw IllegalStateException("GlobalContext can only be set once");
            }
        }

    }
}