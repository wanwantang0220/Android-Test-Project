package ybq.android.myapplication.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.SupportFragment

import ybq.android.myapplication.R

/**
 * A simple [Fragment] subclass.
 */
class SecondHomeFragment : SupportFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_home, container, false)
    }


    companion object{

        fun  newInstance():SecondHomeFragment{
            val fragment = SecondHomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
