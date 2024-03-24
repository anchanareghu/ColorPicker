package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ColorPickerViewModel viewModel;
    private TextView cardViewText;
    private CardView cardViewColor;
    private RadioGroup radioGroup;
    private String[] colorsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);

        viewModel = new ViewModelProvider(this).get(ColorPickerViewModel.class);

        cardViewText = findViewById(R.id.cardView_text);
        cardViewColor = findViewById(R.id.cardView_color);
        radioGroup = findViewById(R.id.radio_group);

        colorsArray = getResources().getStringArray(R.array.colors);
        createColorPalette();
    }

    private void createColorPalette() {

        for (int id = 0; id < colorsArray.length; id++) {
            View colorPalette = LayoutInflater.from(this).inflate(R.layout.layout_radio_button, radioGroup, false);
            RadioButton radioButton = (RadioButton) colorPalette.getRootView();
            radioButton.setId(id);

            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(20, 20, 20, 20);
            radioButton.setLayoutParams(params);
            radioButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorsArray[id])));

            radioGroup.addView(radioButton);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String selectedColor = colorsArray[checkedId];

                LiveData<String> liveData = viewModel.getSelectedColor();
                viewModel.setSelectedColor(liveData.getValue());
//                viewModel.setSelectedColor(selectedColor);

                cardViewText.setText(selectedColor);
                cardViewText.setTextColor(Color.parseColor(selectedColor));
                cardViewColor.setCardBackgroundColor(Color.parseColor(selectedColor));
            }
        });
    }
}