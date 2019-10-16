package ybq.android.myapplication.fragment


import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import me.yokeyword.fragmentation.SupportFragment

import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.FirstHomeAdapter
import ybq.android.myapplication.bean.Article
import ybq.android.myapplication.view.DetailTransition
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class FirstHomeFragment : BaseMainFragment(),SwipeRefreshLayout.OnRefreshListener {


    lateinit var refreshLayout: SwipeRefreshLayout
    lateinit var recyclerView: RecyclerView

    private val mTitles = arrayOf("Use imagery to express a distinctive voice and exemplify creative excellence.", "An image that tells a story is infinitely more interesting and informative.", "The most powerful iconic images consist of a few meaningful elements, with minimal distractions.", "Properly contextualized concepts convey your message and brand more effectively.", "Have an iconic point of focus in your imagery. Focus ranges from a single entity to an overarching composition.")

    private val mImgRes = intArrayOf(R.drawable.bg_first, R.drawable.bg_second, R.drawable.bg_third, R.drawable.bg_fourth, R.drawable.bg_fifth)

    private var mAdapter: FirstHomeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_home, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        refreshLayout = view.findViewById(R.id.refresh_layout)
        recyclerView = view.findViewById(R.id.recycler_view_first_fragment)

        refreshLayout.setColorSchemeResources(R.color.colorPrimary)
        refreshLayout.setOnRefreshListener(this)

        mAdapter = FirstHomeAdapter(_mActivity)
        val manager = LinearLayoutManager(_mActivity)
        recyclerView.layoutManager = manager
        recyclerView.adapter = mAdapter

        // Init Datas
        val articleList = ArrayList<Article>()
        for (i in 0..7) {
            val index = i % 5
            val article = Article(mTitles[index],"", mImgRes[index])
            articleList.add(article)
        }
        mAdapter?.setDatas(articleList)

        mAdapter?.setOnItemClickListener(object :FirstHomeAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder) {
                val fragment = FirstDetailFragment.newInstance(mAdapter!!.getItem(position))
                exitTransition = Fade()
                fragment.enterTransition = Fade()
                fragment.sharedElementReturnTransition = DetailTransition()
                fragment.sharedElementEnterTransition = DetailTransition()

                // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
                // 25.1.0+的support包，SharedElement正常
                extraTransaction().addSharedElement((vh as FirstHomeAdapter.MyViewHolder).img, getString(R.string.image_transition))
                        .addSharedElement(vh.tvTitle, "tv")
                        .start(fragment)
            }

        })
    }

    override fun onRefresh() {
        refreshLayout.postDelayed(Runnable { refreshLayout.isRefreshing = false }, 2000)
    }

    companion object{

        fun newInstance():FirstHomeFragment{
            val fragment = FirstHomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
