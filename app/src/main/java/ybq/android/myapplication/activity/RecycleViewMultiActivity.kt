package ybq.android.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import me.yokeyword.fragmentation.SupportFragment
import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.MyViewPagerAdapter
import ybq.android.myapplication.fragment.FirstFragment
import ybq.android.myapplication.fragment.SecondFragment
import ybq.android.myapplication.fragment.ThirdFragment
import ybq.android.myapplication.recycleviewmulti.LayoutFragment
import ybq.android.myapplication.view.BottomBar

class RecycleViewMultiActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_multi)


        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewpager)

//        tabLayout.addTab(tabLayout.newTab().setText("test1"))
//        tabLayout.addTab(tabLayout.newTab().setText("test2"))
        tabLayout.addTab(tabLayout.newTab().setText("test3"))
        tabLayout.addTab(tabLayout.newTab().setText("test4"))

        val fragments = ArrayList<Fragment>()
//        fragments.add(LayoutFragment.newInstance(R.layout.layout_list))
//        fragments.add(LayoutFragment.newInstance(R.layout.layout_grid))
        fragments.add(LayoutFragment.newInstance(R.layout.layout_staggered_grid))
        fragments.add(LayoutFragment.newInstance(R.layout.layout_spannable_grid))


        //自定义的Adapter继承自FragmentPagerAdapter
        val pagerAdapter = MyViewPagerAdapter(supportFragmentManager, fragments)
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


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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
