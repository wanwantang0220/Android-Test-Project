package ybq.android.myapplication.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ybq.android.myapplication.R

class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   lateinit var  title: ImageView

    init {
        title = itemView.findViewById(R.id.title)
    }
}