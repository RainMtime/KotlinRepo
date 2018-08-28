package rainmtime.com.kotlinrepo.movie.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by chunyu on 2018/8/27 下午8:41.
 * Email: 746431278@qq.com
 */
class MainViewPagerAdapter(private val mFragments:ArrayList<Fragment>,private val mFragmentsTabsTitle:ArrayList<String>, fm: FragmentManager) : FragmentPagerAdapter(fm) {


    init {
        if (mFragments.size != mFragmentsTabsTitle.size){
            throw  IllegalStateException("tilte size not equal fragment size ")
        }
    }

    override fun getItem(p0: Int): Fragment {
        return mFragments[p0]
    }

    override fun getCount(): Int {
      return   mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentsTabsTitle[position]
    }
}


