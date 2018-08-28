package rainmtime.com.kotlinrepo.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import rainmtime.com.kotlinrepo.utils.CommonUtils

/**
 * Created by chunyu on 2018/8/27 下午4:57.
 * Email: 746431278@qq.com
 */
abstract class BaseRecyclerViewAdapter<T,VH:RecyclerView.ViewHolder>(val context:Context):RecyclerView.Adapter<VH>(){
    private val mDatas = ArrayList<T>()

    override fun getItemCount(): Int {
      return  mDatas.size
    }

    fun setData(datas:List<T>?){
        if (datas !=null){
            mDatas.clear()
            mDatas.addAll(datas)
            notifyItemRangeChanged(0,mDatas.size)
        }
    }


    fun addData(datas:List<T>?){
        if (!CommonUtils.isCollectionEmpty(datas)){
            val startPos = mDatas.size
            mDatas.addAll(datas!!)
            notifyItemRangeChanged(startPos,datas.size)

        }
    }

    fun getItemData(index:Int):T{
        return mDatas.get(index)
    }
}