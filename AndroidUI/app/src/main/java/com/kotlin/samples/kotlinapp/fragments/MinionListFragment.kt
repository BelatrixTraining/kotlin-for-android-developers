package com.kotlin.samples.kotlinapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.R.id.recyclerView
import com.kotlin.samples.kotlinapp.adapter.MinionAdapter
import com.kotlin.samples.kotlinapp.adapter.MinionItemListener
import com.kotlin.samples.kotlinapp.data.MinionData
import com.kotlin.samples.kotlinapp.extensions.toast
import com.kotlin.samples.kotlinapp.model.Minion
import kotlinx.android.synthetic.main.fragment_minion_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MinionFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MinionListFragment : Fragment() ,MinionItemListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minion_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager= LinearLayoutManager(activity,LinearLayout.VERTICAL,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //1 view container recycler
        //2 model Minion
        //3 origen datos List, Array : List
        //4 row xml : row_minion
        //5 CustomAdapter
        //6 Setear adapter al view adapter= CustomAdapter()

        val minions:List<Minion> = MinionData.getMinions()
        recyclerView.adapter= MinionAdapter(minions,this)
    }

    override fun onSelectedItem(minion: Minion?) {
        activity?.toast("minion $minion")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MinionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MinionListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}