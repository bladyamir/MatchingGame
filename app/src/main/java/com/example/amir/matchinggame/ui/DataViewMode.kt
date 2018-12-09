package com.example.amir.matchinggame.ui

import androidx.lifecycle.ViewModel
import com.example.amir.matchinggame.data.Repository

class DataViewMode(private val repository: Repository)
    :ViewModel(){

    fun getHead()=repository.getHead()

    fun getBody()=repository.getBody()

    fun getLeg()=repository.getLeg()

    fun getAll()=repository.getAll()
}