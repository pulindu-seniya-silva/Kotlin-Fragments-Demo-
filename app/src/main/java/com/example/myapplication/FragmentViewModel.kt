package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {

    private val backgroundColor = MutableLiveData<Int>()

    fun getBackgroundColor(): MutableLiveData<Int> {
        return backgroundColor
    }

    fun setBackgroundColor(color: Int) {
        backgroundColor.value = color
    }
}