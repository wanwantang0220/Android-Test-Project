package ybq.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import ybq.android.myapplication.R
import ybq.android.myapplication.bean.Article
import java.util.ArrayList

class FirstHomeAdapter(context: Context) : RecyclerView.Adapter<FirstHomeAdapter.MyViewHolder>() {

    private val mList = ArrayList<Article>()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = mInflater.inflate(R.layout.item_first_home, parent, false)
        val holder = MyViewHolder(view)
        holder.itemView.setOnClickListener(View.OnClickListener { v ->
            val position = holder.adapterPosition
            if (mClickListener != null) {
                mClickListener?.onItemClick(position, v, holder)
            }
        })
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mList.get(position)

        // 把每个图片视图设置不同的Transition名称, 防止在一个视图内有多个相同的名称, 在变换的时候造成混乱
        // Fragment支持多个View进行变换, 使用适配器时, 需要加以区分
        ViewCompat.setTransitionName(holder.img, (position).toString() + "_image")
        ViewCompat.setTransitionName(holder.tvTitle, (position).toString() + "_tv")

        holder.img.setImageResource(item.imgRes)
        holder.tvTitle.setText(item.title)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var img: ImageView

        init {
            tvTitle = itemView.findViewById<View>(R.id.tv_title) as TextView
            img = itemView.findViewById<View>(R.id.img) as ImageView
        }

    }

    fun setDatas(items: List<Article>) {
        mList.clear()
        mList.addAll(items)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun getItem(position: Int): Article {
        return mList[position]
    }


    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.mClickListener = itemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View, vh: RecyclerView.ViewHolder)
    }

}