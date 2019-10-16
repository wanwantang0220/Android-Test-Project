package ybq.android.myapplication.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyViewPagerAdapter(fm : FragmentManager, fragments: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    val nNum = fragments.size
    val mFragment = fragments

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return mFragment[0]
            }
            1 -> {
                return mFragment[1]
            }
            2 -> {
                return mFragment[2]
            }
        }
        return mFragment[0]
    }

    override fun getCount(): Int {
        return nNum
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }

}