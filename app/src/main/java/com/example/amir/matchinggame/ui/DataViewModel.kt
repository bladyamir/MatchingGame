package com.example.amir.matchinggame.ui

import androidx.lifecycle.ViewModel
import com.example.amir.matchinggame.data.Repository

class DataViewModel(private val repository: Repository)
    :ViewModel(){

    fun hedClicked()=repository.headClicked()

    fun bodyClicked()=repository.bodyClicked()

    fun legClicked()=repository.legClicked()

    fun getLiveBodyParts()=repository.getLiveBodyParts()

    fun getAll()=repository.getAll()
}