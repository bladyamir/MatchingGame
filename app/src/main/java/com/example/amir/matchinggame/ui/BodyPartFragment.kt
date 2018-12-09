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

    var imageResourse:Int?=0

    private var clickListener:IClickListener?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_body_part,container,false)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        clickListener=context as IClickListener
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        body_part_image_view.setImageResource(imageResourse)

        body_part_image_view.setOnClickListener(View.OnClickListener { view -> clickListener!!.imageClicked(view) })
    }

    interface IClickListener{
        fun imageClicked(view:View)
    }
}