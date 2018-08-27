package rainmtime.com.kotlinrepo.utils

import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import rainmtime.com.kotlinrepo.global.GlobalContext

/**
 * Created by chunyu on 2018/8/27 下午2:34.
 * Email: 746431278@qq.com
 */
object ResUtils{

    fun getString(@StringRes id:Int):String{
        return GlobalContext.Companion.get().resources.getString(id);
    }

    fun getColor(@ColorRes id:Int):Int{
        return GlobalContext.Companion.get().resources.getColor(id)
    }

    fun getString(@StringRes id:Int,str:String):String{
        return String.format(getString(id),str)
    }
}