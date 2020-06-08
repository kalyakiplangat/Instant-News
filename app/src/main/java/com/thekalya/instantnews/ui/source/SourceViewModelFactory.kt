package com.thekalya.instantnews.ui.source

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class SourceViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SourceViewModel::class.java)){
            return SourceViewModel() as T
        }
        throw IllegalArgumentException("unknown viewModel")
    }
}