package ybq.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.lucasr.twowayview.TwoWayLayoutManager
import org.lucasr.twowayview.widget.StaggeredGridLayoutManager
import org.lucasr.twowayview.widget.TwoWayView
import ybq.android.myapplication.R
import ybq.android.myapplication.view.viewholder.SimpleViewHolder
import java.util.ArrayList

class LayoutStaggeredGridAdapter(context: Context, recyclerView: TwoWayView) : RecyclerView.Adapter<SimpleViewHolder>() {

    private val COUNT = 20

    private var mContext: Context = context
    private var mRecyclerView: TwoWayView = recyclerView
    private var mItems: ArrayList<Int> = ArrayList()
    private var mCurrentItemId = 0


    init {
        for (i in 0 until COUNT) {
            mItems.add(R.drawable.bg_first)
            mItems.add(R.drawable.bg_fifth)
            mItems.add(R.drawable.j1)
            mItems.add(R.drawable.j2)
            mItems.add(R.drawable.j3)
            mItems.add(R.drawable.j4)
            mItems.add(R.drawable.bg_third)
            mItems.add(R.drawable.bg_second)
            mItems.add(R.drawable.bg_fourth)
            mItems.add(R.drawable.bg_second)
            mItems.add(R.drawable.pic1)
        }

    }


    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.title.setImageResource(mItems[position])

        val isVertical = mRecyclerView.orientation == TwoWayLayoutManager.Orientation.VERTICAL
        val itemView = holder.itemView

        val itemId = position

        val dimenId: Int
        if (itemId % 3 == 0) {
            dimenId = R.dimen.staggered_child_medium
        } else if (itemId % 5 == 0) {
            dimenId = R.dimen.staggered_child_large
        } else if (itemId % 7 == 0) {
            dimenId = R.dimen.staggered_child_xlarge
        } else {
            dimenId = R.dimen.staggered_child_small
        }


        val span: Int
        if (itemId == 2) {
            span = 2
        } else {
            span = 1
        }

        val size = mContext.resources.getDimensionPixelSize(dimenId)

        val lp = itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams

        if (!isVertical) {
            lp.span = span
            lp.width = size
            itemView.layoutParams = lp
        } else {
            lp.span = span
            lp.height = size
            itemView.layoutParams = lp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false)
        return SimpleViewHolder(view)

    }

}