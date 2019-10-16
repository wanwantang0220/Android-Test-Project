package ybq.android.myapplication.activity

import android.os.Bundle
import android.widget.Button
import me.yokeyword.fragmentation.SupportActivity
import me.yokeyword.fragmentation.SupportFragment
import ybq.android.myapplication.R
import ybq.android.myapplication.fragment.FirstHomeFragment
import ybq.android.myapplication.fragment.SecondHomeFragment

class ZhiHuFragmentActivity : SupportActivity() {

    private val FIRST = 0
    private val SECOND = 1

    lateinit var btn1: Button
    lateinit var btn2: Button


    private val mFragments = arrayOfNulls<SupportFragment>(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhi_hu_fragment)


        val firstFragment = findFragment(FirstHomeFragment::class.java)
        if (firstFragment == null) {
            mFragments[FIRST] = FirstHomeFragment.newInstance()
            mFragments[SECOND] = SecondHomeFragment.newInstance()

            loadMultipleRootFragment(R.id.fl_container, FIRST, mFragments[FIRST], mFragments[SECOND])
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment
            mFragments[SECOND] = findFragment(SecondHomeFragment::class.java)
        }

        initView()

    }

    private fun initView() {

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        btn1.setOnClickListener {
            showHideFragment(mFragments[FIRST], mFragments[SECOND])
        }

        btn2.setOnClickListener {
            showHideFragment(mFragments[SECOND], mFragments[FIRST])
        }
    }
}
