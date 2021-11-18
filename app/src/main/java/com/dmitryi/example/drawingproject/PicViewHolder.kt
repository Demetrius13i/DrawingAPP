package com.dmitryi.example.drawingproject

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pics: Int) {

        val picsImageView: ImageView = itemView.findViewById(R.id.pic_image_view)
        picsImageView.setImageResource(pics)

    }


}