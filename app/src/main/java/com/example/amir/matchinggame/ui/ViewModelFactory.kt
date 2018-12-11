package com.example.amir.matchinggame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.amir.matchinggame.data.Repository

class ViewModelFactory(private val repository: Repository) :ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataViewModel(repository) as T
    }
}