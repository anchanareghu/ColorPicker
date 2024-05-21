package com.example.colorpicker

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.Before

class ColorPickerViewModelTest {

    private lateinit var viewModel: ColorPickerViewModel

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = ColorPickerViewModel()
    }

    @Test
    fun testInitialColor() {
        val observer = Observer<String> {}
        try {
            viewModel.selectedColor.observeForever(observer)
            assertEquals("#FF000000", viewModel.selectedColor.value)
        } finally {
            viewModel.selectedColor.removeObserver(observer)
        }
    }

    @Test
    fun testSetSelectedColor() {
        val observer = Observer<String> {}
        try {
            viewModel.selectedColor.observeForever(observer)
            viewModel.setSelectedColor("#00FF00")
            assertEquals("#00FF00", viewModel.selectedColor.value)
        } finally {
            viewModel.selectedColor.removeObserver(observer)
        }
    }
}
