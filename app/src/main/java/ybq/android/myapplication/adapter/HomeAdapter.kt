package ybq.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ybq.android.myapplication.R
import ybq.android.myapplication.bean.Article
import java.util.ArrayList

class HomeAdapter(context: Context) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private val mList = ArrayList<Article>()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = mInflater.inflate(R.layout.item_home_adapter, parent, false)
        val holder = MyViewHolder(view)
        holder.itemView.setOnClickListener { v ->
            val position = holder.adapterPosition
            if (mClickListener != null) {
                mClickListener?.onItemClick(position, v)
            }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item:Article = mList[position]
        holder.tvTitle.text = item.title
        holder.tvContent.text = item.content
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var tvTitle: TextView
        lateinit var tvContent: TextView

        init {
            tvTitle = itemView.findViewById<View>(R.id.tv_title) as TextView
            tvContent = itemView.findViewById<View>(R.id.tv_content) as TextView
        }

    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.mClickListener = itemClickListener
    }


    fun getItem(position: Int):Article{
        return  mList[position]
    }

    fun setDatas(items: List<Article>) {
        mList.clear()
        mList.addAll(items)
    }


    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View)
    }
}