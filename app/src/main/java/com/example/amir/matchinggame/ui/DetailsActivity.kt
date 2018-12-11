package com.example.amir.matchinggame.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.amir.matchinggame.R
import com.example.amir.matchinggame.utils.Injector
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(){

    private var initialze:Boolean=false

    private lateinit var headFragment:BodyPartFragment

    private lateinit var bodyFragment:BodyPartFragment

    private lateinit var legFragment:BodyPartFragment

    private lateinit var viewModel: DataViewModel

    private lateinit var targetedFragment:BodyPartFragment

    private var targetedContainer:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)

        initialize()

        headFragment=BodyPartFragment()

        bodyFragment=BodyPartFragment()

        legFragment=BodyPartFragment()

    }

    private fun initialize() {
        val factory = Injector.provideViewModelFactory()
       viewModel = ViewModelProviders.of(this, factory)
            .get(DataViewModel::class.java)
        viewModel.getLiveBodyParts()
            .observe(this, Observer {bodyPartsModel->
                if(!initialze){

                    initializeUI(bodyPartsModel)

                    initialze=true

                }else{

                    targetedFragment.imageResourse=bodyPartsModel.hotImage
                    refreshFragment(targetedContainer,targetedFragment)
                }
            })

        initializeClickEvent()

    }

    private fun initializeClickEvent() {

        head_fragment.setOnClickListener(View.OnClickListener {
            targetedFragment=headFragment
            targetedContainer=R.id.head_fragment
            viewModel.hedClicked()
        })

        body_fragment.setOnClickListener(View.OnClickListener {
            targetedFragment=bodyFragment
            targetedContainer=R.id.body_fragment
            viewModel.bodyClicked()
        })

        leg_fragment.setOnClickListener(View.OnClickListener {
            targetedFragment=legFragment
            targetedContainer=R.id.leg_fragment
            viewModel.legClicked()
        })

    }


    private fun initializeUI(bodyPartsModel: BodyPartsModel) {
        headFragment.imageResourse = bodyPartsModel.headImage

        addFragment(R.id.head_fragment,headFragment)

        bodyFragment.imageResourse = bodyPartsModel.bodyImage

        addFragment(R.id.body_fragment,bodyFragment)

        legFragment.imageResourse = bodyPartsModel.legImage

        addFragment(R.id.leg_fragment,legFragment)
    }

    private fun addFragment(containterId:Int, fragment:Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(containterId, fragment)
            .commit()
    }

    private fun refreshFragment(containterId:Int, fragment:Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(containterId, fragment)
            .commit()
    }

}
