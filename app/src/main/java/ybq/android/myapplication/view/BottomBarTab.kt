package ybq.android.myapplication.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import ybq.android.myapplication.R

class BottomBarTab(context: Context, @DrawableRes icon:Int)
    : FrameLayout(context) {

    private var mIcon: ImageView? = null
    private var mContext: Context? = null
    private var mTabPosition = -1

    init {
        initView(context, icon)
    }

    private fun initView(context: Context, icon: Int) {
        mContext = context
        val typedArray = context.obtainStyledAttributes(intArrayOf(R.attr.selectableItemBackgroundBorderless))
        val drawable = typedArray.getDrawable(0)
        setBackgroundDrawable(drawable)
        typedArray.recycle()

        mIcon = ImageView(context)
        val size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 27f, resources.displayMetrics).toInt()
        val params = FrameLayout.LayoutParams(size, size)
        params.gravity = Gravity.CENTER
        mIcon!!.setImageResource(icon)
        mIcon!!.layoutParams = params
        mIcon!!.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect))
        addView(mIcon)
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        if (selected) {
            mIcon!!.setColorFilter(ContextCompat.getColor(mContext!!, R.color.colorPrimary))
        } else {
            mIcon!!.setColorFilter(ContextCompat.getColor(mContext!!, R.color.tab_unselect))
        }
    }

    fun setTabPosition(position: Int) {
        mTabPosition = position
        if (position == 0) {
            isSelected = true
        }
    }

    fun getTabPosition(): Int {
        return mTabPosition
    }
}