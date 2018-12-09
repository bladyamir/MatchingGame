package com.example.amir.matchinggame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.amir.matchinggame.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val headFragment=BodyPartFragment()

        val fragmentManager=supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.hed_fragment,headFragment)
            .commit()
    }
}
