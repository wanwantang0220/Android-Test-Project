package ybq.android.myapplication.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonCancellable.start

import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.HomeAdapter
import ybq.android.myapplication.bean.Article
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    private var mTitles: Array<String>? = null
    private var mContents: Array<String>? = null

    private var mAdapter: HomeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        initView(view!!)


        return view
    }

    private fun initView(view: View) {
        mTitles = resources.getStringArray(R.array.array_title) as Array<String>
        mContents = resources.getStringArray(R.array.array_content)as Array<String>


        recyclerView = view.findViewById(R.id.rv_first_fragment)
        mAdapter = HomeAdapter(activity!!)
        val manager = LinearLayoutManager(activity!!)
        recyclerView.setLayoutManager(manager)
        recyclerView.setAdapter(mAdapter)

        mAdapter?.setOnItemClickListener(object : HomeAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, view: View) {

            }
        })

        // Init Datas
        val articleList = ArrayList<Article>()
        for (i in 0..14) {
            val index = (Math.random() * 3).toInt()
            val article = Article(mTitles!![index], mContents!![index])
            articleList.add(article)
        }
        mAdapter?.setDatas(articleList)
    }


//    start(DetailFragment.newInstance(mAdapter.getItem(position).getTitle()))

}
