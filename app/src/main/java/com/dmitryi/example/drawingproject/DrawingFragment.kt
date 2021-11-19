package com.dmitryi.example.drawingproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DrawingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_drawing, container, false)

        val picslist: List<Int> = listOf(
            (R.drawable.lyntik),
            (R.drawable.packpacka1owl),
            (R.drawable.packpacka2butterfly),
            (R.drawable.watermellon)
        )

        val picRecyclerView: RecyclerView = view.findViewById(R.id.picRecycle)
        picRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        picRecyclerView.adapter = PicAdapter(picslist)

        return view
    }


}

