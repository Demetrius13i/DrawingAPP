package com.dmitryi.example.drawingproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView



class DrawingFragment : Fragment() {

    private lateinit var backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = return inflater.inflate(R.layout.fragment_drawing, container, false)

        backButton.findViewById<View>(R.id.back_picfragment_button)

        backButton.setOnClickListener {
            onDestroy()
        }
        return view
    }


}

