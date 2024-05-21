package com.example.colorpicker

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.colorpicker.ui.theme.ColorPickerTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ColorPickerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorPickerTheme {
                ColorPickerApp(viewModel)
            }
        }
    }
}
