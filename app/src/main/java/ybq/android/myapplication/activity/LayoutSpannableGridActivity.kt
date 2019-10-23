package ybq.android.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.lucasr.twowayview.ItemClickSupport
import org.lucasr.twowayview.widget.DividerItemDecoration
import org.lucasr.twowayview.widget.TwoWayView
import ybq.android.myapplication.R
import ybq.android.myapplication.adapter.LayoutSpannableAdapter
import ybq.android.myapplication.adapter.LayoutStaggeredGridAdapter

class LayoutSpannableGridActivity : AppCompatActivity() {

    lateinit var mRecyclerView: TwoWayView
    private var mToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_spannable_grid)

        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
        mToast?.setGravity(Gravity.CENTER, 0, 0)

        mRecyclerView = findViewById(R.id.list)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.isLongClickable = true

        updateState(RecyclerView.SCROLL_STATE_IDLE)

        val itemClick = ItemClickSupport.addTo(mRecyclerView)
        itemClick.setOnItemClickListener { parent, child, position, id ->
            mToast?.setText("Item clicked: $position")
            mToast?.show()
        }

        val divider = resources.getDrawable(R.drawable.divider)
        mRecyclerView.addItemDecoration(DividerItemDecoration(divider))

        mRecyclerView.adapter = LayoutSpannableAdapter(this, mRecyclerView)
    }

    private fun updateState(scrollState: Int) {
        var stateName = "Undefined"
        when (scrollState) {
            RecyclerView.SCROLL_STATE_IDLE -> stateName = "Idle"

            RecyclerView.SCROLL_STATE_DRAGGING -> stateName = "Dragging"

            RecyclerView.SCROLL_STATE_SETTLING -> stateName = "Flinging"
        }

        Log.i("TAG", "stateName = $stateName")
    }

}
