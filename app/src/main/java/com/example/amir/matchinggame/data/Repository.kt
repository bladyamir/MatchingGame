package com.example.amir.matchinggame.data

import com.example.amir.matchinggame.R

class Repository private constructor(){

    fun getHead()= mutableListOf<Int>(
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

    fun getBody()= mutableListOf(
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

    fun getLegs()= mutableListOf(
        R.drawable.legs1,
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

    fun getAll():MutableList<Int>{
        var all:MutableList<Int>
        all=getHead().let { head->
            getBody().let { body->
                getLegs().let { legs->head+body+legs }.toMutableList()
            }
        }

        return all
    }
    
    companion object {
        @Volatile private var instance:Repository?=null
        fun getInstance()=
            instance?: synchronized(lock = this){
                instance?: Repository().also { it }
            }
        }
    }