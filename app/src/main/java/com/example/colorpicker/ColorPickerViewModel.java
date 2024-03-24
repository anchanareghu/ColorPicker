package com.example.colorpicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColorPickerViewModel extends ViewModel {
    MutableLiveData<String> selectedColor = new MutableLiveData<>();

    public LiveData<String> getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String color) {
        selectedColor.setValue(color);
    }

}