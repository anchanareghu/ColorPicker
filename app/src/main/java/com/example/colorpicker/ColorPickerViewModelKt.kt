package com.example.colorpicker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorPickerViewModelKt : ViewModel() {
    private var selectedColor = MutableLiveData<String>()
    fun getSelectedColor(): LiveData<String> {
        return selectedColor
    }

    fun setSelectedColor(color: String) {
        selectedColor.value = color
    }
}