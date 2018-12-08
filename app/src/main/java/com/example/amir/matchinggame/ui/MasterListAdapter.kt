package com.example.amir.matchinggame.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class MasterListAdapter constructor(private val context: Context, private val imageIds:MutableList<Int>) :BaseAdapter() {
    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return imageIds.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imageView:ImageView
        if(convertView == null){
            imageView=ImageView(context)
            imageView.scaleType=ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8,8,8,8)
        }else{
            imageView= convertView as ImageView
        }

        imageView.setImageResource(imageIds[position])

        return imageView
    }

}