package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView$OnEditorActionListener;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

class TimePickerTextInputKeyController implements View$OnKeyListener, TextView$OnEditorActionListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    TimePickerTextInputKeyController(ChipTextInputComboView arg2, ChipTextInputComboView arg3, TimeModel arg4) {
        super();
        this.keyListenerRunning = false;
        this.hourLayoutComboView = arg2;
        this.minuteLayoutComboView = arg3;
        this.time = arg4;
    }

    public void bind() {
        TextInputLayout v0 = this.hourLayoutComboView.getTextInput();
        TextInputLayout v1 = this.minuteLayoutComboView.getTextInput();
        EditText v0_1 = v0.getEditText();
        EditText v1_1 = v1.getEditText();
        v0_1.setImeOptions(0x10000005);
        v1_1.setImeOptions(0x10000006);
        v0_1.setOnEditorActionListener(((TextView$OnEditorActionListener)this));
        v0_1.setOnKeyListener(((View$OnKeyListener)this));
        v1_1.setOnKeyListener(((View$OnKeyListener)this));
    }

    private void clearPrefilledText(EditText arg2) {
        if(arg2.getSelectionStart() == 0 && arg2.length() == 2) {
            arg2.getText().clear();
        }
    }

    private void moveSelection(int arg5) {
        ChipTextInputComboView v0 = this.minuteLayoutComboView;
        boolean v2 = true;
        boolean v1 = arg5 == 12 ? true : false;
        v0.setChecked(v1);
        v0 = this.hourLayoutComboView;
        if(arg5 == 10) {
        }
        else {
            v2 = false;
        }

        v0.setChecked(v2);
        this.time.selection = arg5;
    }

    public boolean onEditorAction(TextView arg1, int arg2, KeyEvent arg3) {
        boolean v1 = arg2 == 5 ? true : false;
        if(v1) {
            this.moveSelection(12);
        }

        return v1;
    }

    private boolean onHourKeyPress(int arg4, KeyEvent arg5, EditText arg6) {
        Editable v0 = arg6.getText();
        if(v0 == null) {
            return 0;
        }

        if(arg4 >= 7 && arg4 <= 16 && arg5.getAction() == 1) {
            int v2 = 2;
            if(arg6.getSelectionStart() == v2 && v0.length() == v2) {
                this.moveSelection(12);
                return 1;
            }
        }

        this.clearPrefilledText(arg6);
        return 0;
    }

    public boolean onKey(View arg4, int arg5, KeyEvent arg6) {
        if(this.keyListenerRunning) {
            return 0;
        }

        this.keyListenerRunning = true;
        boolean v4 = this.time.selection == 12 ? this.onMinuteKeyPress(arg5, arg6, ((EditText)arg4)) : this.onHourKeyPress(arg5, arg6, ((EditText)arg4));
        this.keyListenerRunning = false;
        return v4;
    }

    private boolean onMinuteKeyPress(int arg2, KeyEvent arg3, EditText arg4) {
        if(arg2 == 67 && arg3.getAction() == 0 && (TextUtils.isEmpty(arg4.getText()))) {
            this.moveSelection(10);
            return 1;
        }

        this.clearPrefilledText(arg4);
        return 0;
    }
}

