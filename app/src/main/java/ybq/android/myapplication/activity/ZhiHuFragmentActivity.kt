package ybq.android.myapplication.activity

import android.os.Bundle
import androidx.core.app.ActivityCompat
import me.yokeyword.fragmentation.SupportActivity
import me.yokeyword.fragmentation.SupportFragment
import ybq.android.myapplication.R
import ybq.android.myapplication.fragment.BaseMainFragment
import ybq.android.myapplication.fragment.ZhiHuFirstFragment
import ybq.android.myapplication.fragment.ZhiHuSecondFragment
import ybq.android.myapplication.view.BottomBar
import ybq.android.myapplication.view.BottomBarTab

class ZhiHuFragmentActivity : SupportActivity(), BaseMainFragment.OnBackToFirstListener {


    val FIRST = 0
    val SECOND = 1
    val THIRD = 2
    val FOURTH = 3

    private val mFragments = arrayOfNulls<SupportFragment>(4)

    lateinit var mBottomBar: BottomBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhi_hu_fragment)

        val firstFragment = findFragment(ZhiHuFirstFragment::class.java)
        if (firstFragment == null) {
            mFragments[FIRST] = ZhiHuFirstFragment.newInstance()
            mFragments[SECOND] = ZhiHuSecondFragment.newInstance()

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND])
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment
            mFragments[SECOND] = findFragment(ZhiHuSecondFragment::class.java)
        }

        initView()

    }

    private fun initView() {
        mBottomBar = findViewById(R.id.bottomBar)

        mBottomBar.addItem(BottomBarTab(this, R.drawable.ic_home_white_24dp))
                .addItem(BottomBarTab(this, R.drawable.ic_discover_white_24dp))

        mBottomBar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int, prePosition: Int) {
                showHideFragment(mFragments[position], mFragments[prePosition])
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabReselected(position: Int) {
//                val currentFragment = mFragments[position]
//                val count = currentFragment?.childFragmentManager?.backStackEntryCount
//
//                // 如果不在该类别Fragment的主页,则回到主页;
//                if (count!! > 1) {
//                    if (currentFragment is ZhiHuFirstFragment) {
//                        currentFragment.popToChild(ZhiHuFirstFragment::class.java, false)
//                    } else if (currentFragment is ZhiHuSecondFragment) {
//                        //currentFragment.popToChild(ViewPagerFragment::class.java, false)
//                    }
//                    return
//                }


            }
        })


    }


//    override fun onBackPressedSupport() {
//        if (supportFragmentManager.backStackEntryCount > 1) {
//            pop()
//        } else {
//            ActivityCompat.finishAfterTransition(this)
//        }
//    }

    override fun onBackToFirstFragment() {
        mBottomBar.setCurrentItem(0)
    }

}
