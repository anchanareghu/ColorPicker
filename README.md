# ColorPicker App

## Overview

ColorPicker is a simple Android application that allows users to pick colors and view their hexadecimal values. This project highlights the usage of ViewModel architecture component in an Android app.

## Description

ColorPicker app allows users to select colors from a predefined list and view their corresponding hexadecimal values. It showcases the implementation of ViewModel to manage UI-related data and handle configuration changes efficiently.

## ViewModel Usage

The ViewModel in this project is utilized to efficiently manage UI-related data and handle configuration changes. Here's how ViewModel is integrated into the project:

1. **ColorViewModel Class**: The `ColorViewModel` class extends `ViewModel` and holds the selected color data.

   ```kotlin
   class ColorViewModel : ViewModel() {
       private val selectedColor = MutableLiveData<String>()

       fun setSelectedColor(color: String) {
           selectedColor.value = color
       }

       fun getSelectedColor(): LiveData<String> {
           return selectedColor
       }
   }
   ```

2. **ViewModelProvider**: ViewModelProvider is used to retrieve an instance of the ViewModel in the fragment.

   ```kotlin
   viewModel = ViewModelProvider(requireActivity()).get(ColorViewModel::class.java)
   ```

3. **Observing LiveData**: LiveData objects within the ViewModel are observed to update the UI based on changes in the selected color.

   ```kotlin
   viewModel.getSelectedColor().observe(viewLifecycleOwner, { color ->
       // Update UI with the selected color
   })
   ```

4. **ViewModel Lifecycle**: ViewModel lifecycle is managed by the associated fragment. It is automatically cleared when the fragment is destroyed, preventing memory leaks.

## Screenshots
 <img src="app/src/main/res/drawable/screenshot_01.png" width="200" /> 

<img src="app/src/main/res/drawable/screenshot_02.png" width="200" />
