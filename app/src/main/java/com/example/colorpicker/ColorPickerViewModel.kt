package com.example.colorpicker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorPickerViewModel : ViewModel() {

    private val _selectedColor = MutableLiveData("#FF000000")
    val selectedColor: LiveData<String> get() = _selectedColor

    fun setSelectedColor(color: String) {
        _selectedColor.value = color
    }
}
