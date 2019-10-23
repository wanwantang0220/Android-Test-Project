package ybq.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.lucasr.twowayview.TwoWayLayoutManager
import org.lucasr.twowayview.widget.SpannableGridLayoutManager
import org.lucasr.twowayview.widget.StaggeredGridLayoutManager
import org.lucasr.twowayview.widget.TwoWayView
import ybq.android.myapplication.R
import ybq.android.myapplication.view.viewholder.SimpleViewHolder
import java.util.ArrayList

class LayoutSpannableAdapter (context: Context, recyclerView: TwoWayView) : RecyclerView.Adapter<SimpleViewHolder>() {

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

        val lp = itemView.layoutParams as SpannableGridLayoutManager.LayoutParams

//        val span1 = if (itemId % 2 ==0 ) 2 else 1
//        val span2 = if (itemId % 3==0) 3 else 1
//
//        val colSpan =   if (itemId % 2 == 0) 2 else 1//列
//        val rowSpan = if (itemId % 2 == 0) 3 else 2    //行


        val colSpan =  if (itemId == 0) 2 else if (itemId == 3) 3 else 1
        val rowSpan =  if (itemId == 0 || itemId == 3) 2 else 1



        if (lp.rowSpan != rowSpan || lp.colSpan != colSpan) {
            lp.rowSpan = rowSpan
            lp.colSpan = colSpan
            itemView.layoutParams = lp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false)
        return SimpleViewHolder(view)

    }

}