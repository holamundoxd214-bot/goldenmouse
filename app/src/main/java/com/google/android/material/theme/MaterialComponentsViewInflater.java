package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    public MaterialComponentsViewInflater() {
        super();
    }

    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context arg1, AttributeSet arg2) {
        return new MaterialAutoCompleteTextView(arg1, arg2);
    }

    protected AppCompatButton createButton(Context arg1, AttributeSet arg2) {
        return new MaterialButton(arg1, arg2);
    }

    protected AppCompatCheckBox createCheckBox(Context arg1, AttributeSet arg2) {
        return new MaterialCheckBox(arg1, arg2);
    }

    protected AppCompatRadioButton createRadioButton(Context arg1, AttributeSet arg2) {
        return new MaterialRadioButton(arg1, arg2);
    }

    protected AppCompatTextView createTextView(Context arg1, AttributeSet arg2) {
        return new MaterialTextView(arg1, arg2);
    }
}

