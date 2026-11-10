package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    class com.google.android.material.timepicker.ChipTextInputComboView$1 {
    }

    class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";

        TextFormatter(ChipTextInputComboView arg1, com.google.android.material.timepicker.ChipTextInputComboView$1 arg2) {
            this(arg1);
        }

        private TextFormatter(ChipTextInputComboView arg1) {
            ChipTextInputComboView.this = arg1;
            super();
        }

        public void afterTextChanged(Editable arg4) {
            boolean v0 = TextUtils.isEmpty(((CharSequence)arg4));
            ChipTextInputComboView v1 = ChipTextInputComboView.this;
            String v2 = "00";
            if(v0) {
                v1.chip.setText(ChipTextInputComboView.this.formatText(((CharSequence)v2)));
                return;
            }

            String v4 = v1.formatText(((CharSequence)arg4));
            Chip v0_1 = ChipTextInputComboView.this.chip;
            if(TextUtils.isEmpty(((CharSequence)v4))) {
                v4 = ChipTextInputComboView.this.formatText(((CharSequence)v2));
            }

            v0_1.setText(((CharSequence)v4));
        }
    }

    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    public ChipTextInputComboView(Context arg2) {
        this(arg2, null);
    }

    public ChipTextInputComboView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ChipTextInputComboView(Context arg4, AttributeSet arg5, int arg6) {
        super(arg4, arg5, arg6);
        LayoutInflater v4 = LayoutInflater.from(arg4);
        View v5 = v4.inflate(layout.material_time_chip, ((ViewGroup)this), false);
        this.chip = ((Chip)v5);
        ((Chip)v5).setAccessibilityClassName("android.view.View");
        View v4_1 = v4.inflate(layout.material_time_input, ((ViewGroup)this), false);
        this.textInputLayout = ((TextInputLayout)v4_1);
        EditText v0 = ((TextInputLayout)v4_1).getEditText();
        this.editText = v0;
        v0.setVisibility(4);
        TextFormatter v1 = new TextFormatter(this, null);
        this.watcher = ((TextWatcher)v1);
        v0.addTextChangedListener(((TextWatcher)v1));
        this.updateHintLocales();
        this.addView(v5);
        this.addView(v4_1);
        this.label = this.findViewById(id.material_label);
        v0.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.label, v0.getId());
        v0.setSaveEnabled(false);
        v0.setLongClickable(false);
    }

    static String access$100(ChipTextInputComboView arg0, CharSequence arg1) {
        return arg0.formatText(arg1);
    }

    static Chip access$200(ChipTextInputComboView arg0) {
        return arg0.chip;
    }

    public void addInputFilter(InputFilter arg3) {
        InputFilter[] v0 = this.editText.getFilters();
        Object[] v1 = Arrays.copyOf(((Object[])v0), v0.length + 1);
        v1[v0.length] = arg3;
        this.editText.setFilters(((InputFilter[])v1));
    }

    private String formatText(CharSequence arg1) {
        return TimeModel.formatText(this.getResources(), arg1);
    }

    CharSequence getChipText() {
        return this.chip.getText();
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    public boolean isChecked() {
        return this.chip.isChecked();
    }

    protected void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
        this.updateHintLocales();
    }

    public void setChecked(boolean arg4) {
        this.chip.setChecked(arg4);
        EditText v0 = this.editText;
        int v2 = arg4 ? 0 : 4;
        v0.setVisibility(v2);
        Chip v0_1 = this.chip;
        int v4 = arg4 ? 8 : 0;
        v0_1.setVisibility(v4);
        if(this.isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.editText, false);
        }
    }

    public void setChipDelegate(AccessibilityDelegateCompat arg1) {
        ViewCompat.setAccessibilityDelegate(this.chip, arg1);
    }

    public void setCursorVisible(boolean arg1) {
        this.editText.setCursorVisible(arg1);
    }

    public void setHelperText(CharSequence arg1) {
        this.label.setText(arg1);
    }

    public void setOnClickListener(View$OnClickListener arg1) {
        this.chip.setOnClickListener(arg1);
    }

    public void setTag(int arg1, Object arg2) {
        this.chip.setTag(arg1, arg2);
    }

    public void setText(CharSequence arg3) {
        String v3 = this.formatText(arg3);
        this.chip.setText(((CharSequence)v3));
        if(!TextUtils.isEmpty(((CharSequence)v3))) {
            this.editText.removeTextChangedListener(this.watcher);
            this.editText.setText(((CharSequence)v3));
            this.editText.addTextChangedListener(this.watcher);
        }
    }

    public void toggle() {
        this.chip.toggle();
    }

    private void updateHintLocales() {
        this.editText.setImeHintLocales(this.getContext().getResources().getConfiguration().getLocales());
    }
}

