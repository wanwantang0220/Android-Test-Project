package ybq.android.myapplication.fragment


import android.content.Context
import androidx.fragment.app.Fragment
import me.yokeyword.fragmentation.SupportFragment

/**
 * A simple [Fragment] subclass.
 */
open class BaseMainFragment : SupportFragment() {

    protected var _mBackToFirstListener: OnBackToFirstListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackToFirstListener) {
            _mBackToFirstListener = context
        } else {
            throw RuntimeException("$context must implement OnBackToFirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        _mBackToFirstListener = null
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    override fun onBackPressedSupport(): Boolean {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild()
        } else {
            if (this is ZhiHuFirstFragment) {   // 如果是 第一个Fragment 则退出app
                _mActivity.finish()
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener!!.onBackToFirstFragment()
            }
        }
        return true
    }

    interface OnBackToFirstListener {
        fun onBackToFirstFragment()
    }


}
