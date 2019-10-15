package ybq.android.myapplication.adapter

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ybq.android.myapplication.fragment.FirstFragment
import ybq.android.myapplication.fragment.SecondFragment
import ybq.android.myapplication.fragment.ThirdFragment

class MyViewPagerAdapter(fm : FragmentManager, numtabs :Int) : FragmentPagerAdapter(fm) {

    val nNum = numtabs

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return FirstFragment()
            }
            1 -> {
                return SecondFragment()
            }
            2 -> {
                return ThirdFragment()
            }
        }
        return null
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