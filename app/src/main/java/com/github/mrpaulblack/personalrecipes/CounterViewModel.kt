package com.github.mrpaulblack.personalrecipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    val counter = MutableLiveData(0);

    fun onCounterClicked() {
        counter.value = (counter.value ?: 0) +1;
    }
}
