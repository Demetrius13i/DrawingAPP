package com.dmitryi.example.drawingproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PicAdapter(private val picList: List<Int>) : RecyclerView.Adapter<PicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicViewHolder {

        val picItemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.pic_list_item, parent)


        return PicViewHolder(picItemView)
    }

    override fun onBindViewHolder(holder: PicViewHolder, position: Int) {
        val pics: Int = picList[position]
        holder.bind(pics)
    }

    override fun getItemCount(): Int {
        return picList.size
    }
}