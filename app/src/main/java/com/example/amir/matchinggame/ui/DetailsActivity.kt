package com.example.amir.matchinggame.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.amir.matchinggame.R
import com.example.amir.matchinggame.utils.Injector

class DetailsActivity : AppCompatActivity() ,BodyPartFragment.IClickListener {

    private var viewModel:DataViewMode?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val factory= Injector.provideViewModelFactory()
        viewModel= ViewModelProviders.of(this,factory)
            .get(DataViewMode::class.java)

        val headFragment=BodyPartFragment()

        if(viewModel!=null){
            headFragment.imageResourse=viewModel.getHead()
        }


        val fragmentManager=supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.hed_fragment,headFragment)
            .commit()

        val bodyFragment=BodyPartFragment()
        bodyFragment.imageResourse=viewModel.getBody()

        fragmentManager.beginTransaction()
            .add(R.id.body_fragment,bodyFragment)
            .commit()

        val legFragment=BodyPartFragment()
        legFragment.imageResourse=viewModel.getLeg()

        fragmentManager.beginTransaction()
            .add(R.id.leg_fragment,legFragment)
            .commit()


    }

    override fun imageClicked(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
