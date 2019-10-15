package ybq.android.myapplication.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ybq.android.myapplication.R

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : MySupportFragment() {


    private var mTitle: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            mTitle = bundle.getString(ARG_TITLE)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }



    companion object{

        val ARG_TITLE = "arg_title"
        internal val KEY_RESULT_TITLE = "title"

        fun newInstance(title: String):DetailFragment{
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(ARG_TITLE, title)
            fragment.arguments = bundle
            return fragment

        }
    }

}
