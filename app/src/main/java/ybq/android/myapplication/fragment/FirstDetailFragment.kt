package ybq.android.myapplication.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.yokeyword.fragmentation.SupportFragment

import ybq.android.myapplication.R
import ybq.android.myapplication.bean.Article

/**
 * A simple [Fragment] subclass.
 */
class FirstDetailFragment : SupportFragment() {



    private var mArticle: Article? = null

   lateinit var mImgDetail: ImageView
   lateinit var mTvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArticle = arguments?.getParcelable(ARG_ITEM)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first_detail, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        mImgDetail = view.findViewById(R.id.img_detail)
        mTvTitle = view.findViewById(R.id.tv_content)

        mImgDetail.setImageResource(mArticle!!.imgRes)
        mTvTitle.text = mArticle!!.title
    }

    companion object{

        private val ARG_ITEM = "arg_item"

        fun newInstance(article: Article):FirstDetailFragment{

            val fragment = FirstDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_ITEM, article)
            fragment.arguments = args
            return fragment
        }
    }

}
