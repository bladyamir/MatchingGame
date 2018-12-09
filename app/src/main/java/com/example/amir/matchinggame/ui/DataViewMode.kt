package com.example.amir.matchinggame.ui

import androidx.lifecycle.ViewModel
import com.example.amir.matchinggame.data.Repository

class DataViewMode(private val repository: Repository)
    :ViewModel(){

    fun getHeads()=repository.getHead()

    fun getBody()=repository.getBody()

    fun getLegs()=repository.getLegs()

    fun getAll()=repository.getAll()
}