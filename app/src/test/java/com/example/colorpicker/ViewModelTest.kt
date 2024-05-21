package com.example.colorpicker

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ColorPickerViewModelTest {

    private var viewModel: ColorPickerViewModel =ColorPickerViewModel()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

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
            viewModel.setSelectedColor("#FFFFFF")
            assertEquals("#FFFFFF", viewModel.selectedColor.value)
        } finally {
            viewModel.selectedColor.removeObserver(observer)
        }
    }
}
