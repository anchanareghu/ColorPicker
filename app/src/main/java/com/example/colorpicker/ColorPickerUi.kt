package com.example.colorpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun ColorPickerApp(viewModel: ColorPickerViewModel) {
    val colors = listOf(
        "#FFB3BA", "#E0AED0", "#FFDFBA", "#FFFFBA", "#BAFFC9",
        "#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#FF000000", "#FFFFFF"
    )
    val selectedColor by viewModel.selectedColor.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(parseColor(selectedColor ?: "#FFFFFF"))
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ColorDetails(selectedColor ?: "#FFFFFF")
        }

        ColorPicker(colors) { color ->
            viewModel.setSelectedColor(color)
        }
    }
}

@Composable
fun ColorPicker(colors: List<String>, onColorSelected: (String) -> Unit) {
    Box(
        Modifier
            .background(Color.DarkGray)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(colors) { color ->
                RadioButton(
                    selected = false,
                    onClick = { onColorSelected(color) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = parseColor(color),
                        unselectedColor = parseColor(color)
                    )
                )
            }
        }
    }
}

@Composable
fun ColorDetails(color: String) {
    OutlinedCard(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(parseColor(color)),
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = color,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun parseColor(colorString: String): Color {
    return try {
        Color(android.graphics.Color.parseColor(colorString))
    } catch (e: IllegalArgumentException) {
        Color.White
    }
}

@Preview
@Composable
fun ColorPickerAppPreview() {
    val viewModel = ColorPickerViewModel()
    ColorPickerApp(viewModel)
}
