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

    private lateinit var viewModel: ColorPickerViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
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
            viewModel.setSelectedColor("#FFFFFF")
            assertEquals("#FFFFFF", viewModel.selectedColor.value)
        } finally {
            viewModel.selectedColor.removeObserver(observer)
        }
    }
}
