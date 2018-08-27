package rainmtime.com.kotlinrepo

import android.app.Application
import com.facebook.stetho.Stetho
import org.litepal.LitePal
import rainmtime.com.kotlinrepo.global.GlobalContext
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by chunyu on 2018/8/15 下午9:00.
 * Email: 746431278@qq.com
 */
class KotlinApplication : Application() {

    var appExecutors:AppExecutors? = null

    override fun onCreate() {
        super.onCreate()

        initialize()

        //全局功能对象
        if (sInitialized.compareAndSet(false, true)) {
            GlobalContext.Companion.set(GlobalContext(this))
        }

    }

    private fun initialize(){
        LitePal.initialize(this)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        )

        appExecutors = AppExecutors()

    }

    companion object {
        private val sInitialized = AtomicBoolean(false)

    }
}