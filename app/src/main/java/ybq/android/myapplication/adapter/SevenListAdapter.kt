package ybq.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ybq.android.myapplication.R
import ybq.android.myapplication.bean.Person

class SevenListAdapter(private val context: Context, private val infos: MutableList<Person>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = inflater.inflate(R.layout.item_recycle_seven, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vholder :ItemHolder = holder as ItemHolder
        vholder.tvName.text = infos.get(position).name
        vholder.tvIntro.text = infos.get(position).sex
    }


    inner class ItemHolder(view:View): RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvIntro = view.findViewById<TextView>(R.id.tvIntro)
    }
}