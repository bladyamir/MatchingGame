package com.example.amir.matchinggame.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.amir.matchinggame.R
import com.example.amir.matchinggame.utils.Injector
import kotlinx.android.synthetic.main.fragment_body_part.*

class BodyPartFragment : Fragment() {
    var imageResourse:Int=0



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_body_part,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        body_part_image_view.setImageResource(imageResourse)
    }
}