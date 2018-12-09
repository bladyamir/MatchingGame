package com.example.amir.matchinggame.utils

import com.example.amir.matchinggame.data.Repository
import com.example.amir.matchinggame.ui.ViewModelFactory

object Injector {
    fun provideViewModelFactory():ViewModelFactory{
        val repository=Repository.getInstance()
        return ViewModelFactory(repository)
    }
}