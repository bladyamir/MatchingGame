package com.example.amir.matchinggame.data

import androidx.lifecycle.MutableLiveData
import com.example.amir.matchinggame.R

class Repository private constructor(){
    private val index:Int=0
    private var liveIndex= MutableLiveData<Int>()

    init {
        liveIndex.value=index
    }

//    fun nextIndec
    private fun getHeads()= mutableListOf<Int>(
        R.drawable.head1,
        R.drawable.head2,
        R.drawable.head3,
        R.drawable.head4,
        R.drawable.head5,
        R.drawable.head6,
        R.drawable.head7,
        R.drawable.head8,
        R.drawable.head9,
        R.drawable.head10,
        R.drawable.head11,
        R.drawable.head12
    )

    private fun getBodys(
    )= mutableListOf(
        R.drawable.body1,
        R.drawable.body2,
        R.drawable.body3,
        R.drawable.body4,
        R.drawable.body5,
        R.drawable.body6,
        R.drawable.body7,
        R.drawable.body8,
        R.drawable.body9,
        R.drawable.body10,
        R.drawable.body11,
        R.drawable.body12
    )

    private fun getLegs()= mutableListOf(
        R.drawable.legs1,
        R.drawable.legs2,
        R.drawable.legs3,
        R.drawable.legs4,
        R.drawable.legs5,
        R.drawable.legs6,
        R.drawable.legs7,
        R.drawable.legs8,
        R.drawable.legs9,
        R.drawable.legs10,
        R.drawable.legs11,
        R.drawable.legs12
    )

    fun getAll():MutableList<Int>{
        var all:MutableList<Int>
        all=getHeads().let { head->
            getBodys().let { body->
                getLegs().let { legs->head+body+legs }.toMutableList()
            }
        }

        return all
    }

    fun getHead()=getHeads()[1]


    fun getLeg()=getLegs()[1]


    fun getBody()= getBodys()[1]
    
    companion object {
        @Volatile private var instance:Repository?=null
        fun getInstance()=
            instance?: synchronized(lock = this){
                instance?: Repository().also { it }
            }
        }
    }
