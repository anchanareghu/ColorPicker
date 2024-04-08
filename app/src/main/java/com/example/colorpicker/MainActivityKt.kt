package com.example.colorpicker

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivityKt : AppCompatActivity() {
    private lateinit var viewModel: ColorPickerViewModelKt
    private lateinit var background: RelativeLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var colorsArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_main)

        viewModel = ViewModelProvider(this).get(ColorPickerViewModelKt::class.java)
        radioGroup = findViewById(R.id.radio_group)
        background = findViewById(R.id.background)

        colorsArray = resources.getStringArray(R.array.colors)
        createColorPalette()
    }

    private fun createColorPalette() {
        for ((id, color) in colorsArray.withIndex()) {
            val colorPalette =
                LayoutInflater.from(this).inflate(R.layout.layout_radio_button, radioGroup, false)
            val radioButton = colorPalette.getRootView() as RadioButton
            radioButton.id = id
            radioButton.layoutParams = RadioGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(20, 20, 20, 20)
            }
            radioButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
            radioGroup.addView(radioButton)
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            openFragment(ColorFragmentKt())
            val selectedColor = colorsArray[checkedId]
            viewModel.setSelectedColor(selectedColor)
        }

        viewModel.getSelectedColor().observe(this, Observer { value ->
            background.setBackgroundColor(Color.parseColor(value))
        })
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}


