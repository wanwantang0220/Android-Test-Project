package ybq.android.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ybq.android.myapplication.R
import ybq.android.myapplication.view.viewholder.FlexBoxViewHolder

class FlexBoxAdapter : RecyclerView.Adapter<FlexBoxViewHolder>() {

    companion object {
        private val CAT_IMAGE_IDS = intArrayOf(
                R.drawable.bg_first,
                R.drawable.j2,
                R.drawable.j1,
                R.drawable.j2,
                R.drawable.j1,
                R.drawable.bg_third,
                R.drawable.bg_fourth,
                R.drawable.bg_fifth

        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlexBoxViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_flexbox, parent, false)
        return FlexBoxViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlexBoxViewHolder, position: Int) {
        val pos = position % CAT_IMAGE_IDS.size
        holder.bindTo(CAT_IMAGE_IDS[pos])
    }

    override fun getItemCount() = CAT_IMAGE_IDS.size
}