package com.example.colorpicker

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class ColorFragmentKt : Fragment() {
    private lateinit var cardViewText: TextView
    private lateinit var cardViewColor: CardView
    private lateinit var viewModel: ColorPickerViewModelKt

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color, container, false)
        cardViewText = view.findViewById(R.id.cardView_text)
        cardViewColor = view.findViewById(R.id.cardView_color)

        viewModel = ViewModelProvider(requireActivity()).get(ColorPickerViewModelKt::class.java)
        viewModel.getSelectedColor().observe(viewLifecycleOwner, Observer { value ->
            cardViewText.text = value
            cardViewText.setTextColor(Color.parseColor(value))
            cardViewColor.setCardBackgroundColor(Color.parseColor(value))
        })
        return view
    }
}