package com.example.amir.matchinggame.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.amir.matchinggame.R
import com.example.amir.matchinggame.utils.Injector
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), BodyPartFragment.ImageClickListener {


    private var initialze: Boolean = false

    private lateinit var headFragment: BodyPartFragment

    private lateinit var bodyFragment: BodyPartFragment

    private lateinit var legFragment: BodyPartFragment

    private lateinit var viewModel: DataViewModel

    private lateinit var targetedFragment: BodyPartFragment

    private lateinit var targetedView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)

        initialize()

        headFragment = BodyPartFragment()

        bodyFragment = BodyPartFragment()

        legFragment = BodyPartFragment()

    }

    private fun initialize() {
        val factory = Injector.provideViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory)
            .get(DataViewModel::class.java)
        viewModel.getLiveBodyParts()
            .observe(this, Observer { bodyPartsModel ->
                if (!initialze) {

                    initializeUI(bodyPartsModel)

                    initialze = true

                } else {

                    targetedView.setImageResource(bodyPartsModel.hotImage)
                }
            })

    }

    private fun initializeUI(bodyPartsModel: BodyPartsModel) {
        headFragment.imageResourse = bodyPartsModel.headImage

        addFragment(R.id.head_fragment, headFragment)

        bodyFragment.imageResourse = bodyPartsModel.bodyImage

        addFragment(R.id.body_fragment, bodyFragment)

        legFragment.imageResourse = bodyPartsModel.legImage

        addFragment(R.id.leg_fragment, legFragment)
    }

    private fun addFragment(containterId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(containterId, fragment)
            .commit()
    }

    override fun imageClick(imageView: View, parentId: Int) {
        targetedView = imageView as ImageView

        when(parentId){
            R.id.head_fragment->Toast.makeText(this,"Head Clicked",Toast.LENGTH_SHORT).show()

            R.id.body_fragment->Toast.makeText(this,"Body Clicked",Toast.LENGTH_SHORT).show()

            R.id.leg_fragment->Toast.makeText(this,"Leg Clicked",Toast.LENGTH_SHORT).show()
        }
    }

}
