package ybq.android.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.MyViewPagerAdapter
import ybq.android.myapplication.fragment.FirstFragment
import ybq.android.myapplication.fragment.SecondFragment
import ybq.android.myapplication.fragment.ThirdFragment


class TabFragmentActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_fragment)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewpager)

        tabLayout.addTab(tabLayout.newTab().setText("test1"))
        tabLayout.addTab(tabLayout.newTab().setText("test2"))
        tabLayout.addTab(tabLayout.newTab().setText("test3"))

        val fragments =  ArrayList<Fragment>()
        fragments.add(Fragment())
        fragments.add(SecondFragment())
        fragments.add(ThirdFragment())

        //自定义的Adapter继承自FragmentPagerAdapter
        val pagerAdapter = MyViewPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = pagerAdapter


        //为TabLayout添加Tab选择事件监听
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {//当标签被选择时回调
                viewPager.currentItem = tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {//当标签从选择变为非选择时回调

            }

            override fun onTabReselected(tab: TabLayout.Tab) {//当标签被重新选择时回调

            }
        })


        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)?.select()

            }

        })
    }

}
