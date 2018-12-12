package com.example.amir.matchinggame.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.amir.matchinggame.R
import kotlinx.android.synthetic.main.fragment_body_part.*

class BodyPartFragment: Fragment() {

    var imageResourse:Int=0

    lateinit var imageClickListerner: ImageClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        imageClickListerner=context as ImageClickListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_body_part,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        body_part_image_view.setImageResource(imageResourse)

        body_part_image_view.setOnClickListener { imageView:View->imageClickListerner.imageClick(imageView,view.id) }

    }

    interface ImageClickListener{

        fun imageClick(imageView:View,parentId:Int)
    }
}