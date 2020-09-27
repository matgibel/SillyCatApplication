package com.example.silly_cat_api.viewmodel

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.silly_cat_api.R
import com.example.silly_cat_api.model.SillyCatResponseItem
import com.example.silly_cat_api.view.SingleCatLayout
import kotlinx.android.synthetic.main.fragment_display.view.*

class FragmentDisplay:Fragment() , OnCatClickListener{

    lateinit var adapter: SillyCatAdapter
    lateinit var recyclerView: RecyclerView
    //lateinit var tmp: MutableList<SillyCatResponseItem>

    //Created catlist to store newly updated list from tmp
    var catlist: ArrayList<SillyCatResponseItem> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_display,container,false)

        recyclerView = view.rv_silly_cat_list
        recyclerView.layoutManager = LinearLayoutManager(activity)

        arguments?.getParcelableArray(EXTRA_DATA_SET)?.let{

            var tmp: ArrayList<SillyCatResponseItem> = ArrayList()

            for (i in 0 until it.size){
                var t = it.get(i) as SillyCatResponseItem

                tmp.add(t)
                //Log.d("FragmentDisplay","Added one Item")
                //Log.d("FragmentDisplay","${it[i]}")
                //Log.d("FragmentDisplay","${tmp.size}")

                catlist.add(t)
            }

            adapter = SillyCatAdapter(tmp, this)


            recyclerView.adapter = adapter
        }

        return view
    }

    companion object{
        const val EXTRA_DATA_SET = "ExtraDataSet"

        fun newInstance(dataSet:List<SillyCatResponseItem>?):FragmentDisplay{
            val fragmentDisplay = FragmentDisplay()
            val bundle = Bundle()

            //dataSet as Parcelable?

            bundle.putParcelableArray(EXTRA_DATA_SET,dataSet?.toTypedArray())
            fragmentDisplay.arguments = bundle

            return fragmentDisplay
        }
    }



    override fun onCatItemClicked(position: Int) {
        Toast.makeText(activity , "Cat"+ catlist[position].id +"Clicked", Toast.LENGTH_LONG).show()
        //Log.d("Position", "Position = ${position}")

        //Using catlist derived from tmp
        val intent = Intent(activity,SingleCatLayout::class.java)

        startActivity(intent)
    }


}