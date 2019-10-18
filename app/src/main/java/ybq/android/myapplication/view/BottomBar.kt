package ybq.android.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import androidx.core.view.ViewCompat

class BottomBar(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val TRANSLATE_DURATION_MILLIS = 200

    private val mInterpolator = AccelerateDecelerateInterpolator()
    private var mVisible = true

    private var mTabLayout: LinearLayout? = null

    private var mTabParams: LinearLayout.LayoutParams? = null
    private var mCurrentPosition = 0
    private var mListener: OnTabSelectedListener? = null

    init {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet) {
        orientation = LinearLayout.VERTICAL

        mTabLayout = LinearLayout(context)
        mTabLayout!!.setBackgroundColor(Color.WHITE)
        mTabLayout!!.orientation = LinearLayout.HORIZONTAL
        addView(mTabLayout, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        mTabParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT)
        mTabParams!!.weight = 1f
    }

    fun addItem(tab: BottomBarTab): BottomBar {
        tab.setOnClickListener(OnClickListener {
            if (mListener == null) return@OnClickListener

            val pos = tab.getTabPosition()
            if (mCurrentPosition == pos) {
                mListener!!.onTabReselected(pos)
            } else {
                mListener!!.onTabSelected(pos, mCurrentPosition)
                tab.setSelected(true)
                mListener!!.onTabUnselected(mCurrentPosition)
                mTabLayout!!.getChildAt(mCurrentPosition).isSelected = false
                mCurrentPosition = pos
            }
        })
        tab.setTabPosition(mTabLayout!!.childCount)
        tab.setLayoutParams(mTabParams)
        mTabLayout!!.addView(tab)
        return this
    }

    fun setOnTabSelectedListener(onTabSelectedListener: OnTabSelectedListener) {
        mListener = onTabSelectedListener
    }

    fun setCurrentItem(position: Int) {
        mTabLayout!!.post { mTabLayout!!.getChildAt(position).performClick() }
    }

    interface OnTabSelectedListener {
        fun onTabSelected(position: Int, prePosition: Int)

        fun onTabUnselected(position: Int)

        fun onTabReselected(position: Int)
    }

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()
        return SavedState(superState, mCurrentPosition)
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        val ss = state as SavedState
        super.onRestoreInstanceState(ss.superState)

        if (mCurrentPosition != ss.position) {
            mTabLayout!!.getChildAt(mCurrentPosition).isSelected = false
            mTabLayout!!.getChildAt(ss.position).isSelected = true
        }
        mCurrentPosition = ss.position
    }

    fun getCurrentItemPosition(): Int {
        return mCurrentPosition
    }

    internal class SavedState : View.BaseSavedState {
        var position: Int = 0

        constructor(source: Parcel) : super(source) {
            position = source.readInt()
        }

        constructor(superState: Parcelable, position: Int) : super(superState) {
            this.position = position
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeInt(position)
        }

        companion object {

            @SuppressLint("ParcelCreator")
            val CREATOR: Parcelable.Creator<SavedState> = object : Parcelable.Creator<SavedState> {
                override fun createFromParcel(`in`: Parcel): SavedState {
                    return SavedState(`in`)
                }

                override fun newArray(size: Int): Array<SavedState?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }


    fun hide() {
        hide(true)
    }

    fun show() {
        show(true)
    }

    fun hide(anim: Boolean) {
        toggle(false, anim, false)
    }

    fun show(anim: Boolean) {
        toggle(true, anim, false)
    }

    fun isVisible(): Boolean {
        return mVisible
    }

    private fun toggle(visible: Boolean, animate: Boolean, force: Boolean) {
        if (mVisible != visible || force) {
            mVisible = visible
            val height = height
            if (height == 0 && !force) {
                val vto = viewTreeObserver
                if (vto.isAlive) {
                    // view树完成测量并且分配空间而绘制过程还没有开始的时候播放动画。
                    vto.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                        override fun onPreDraw(): Boolean {
                            val currentVto = viewTreeObserver
                            if (currentVto.isAlive) {
                                currentVto.removeOnPreDrawListener(this)
                            }
                            toggle(visible, animate, true)
                            return true
                        }
                    })
                    return
                }
            }
            val translationY = if (visible) 0 else height
            if (animate) {
                animate().setInterpolator(mInterpolator)
                        .setDuration(TRANSLATE_DURATION_MILLIS.toLong())
                        .translationY(translationY.toFloat())
            } else {
                ViewCompat.setTranslationY(this, translationY.toFloat())
            }
        }
    }
}