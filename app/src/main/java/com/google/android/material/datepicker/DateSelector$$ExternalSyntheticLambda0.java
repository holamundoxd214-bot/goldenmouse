package com.google.android.material.datepicker;

import android.view.View$OnFocusChangeListener;
import android.view.View;
import android.widget.EditText;

public final class DateSelector$$ExternalSyntheticLambda0 implements View$OnFocusChangeListener {
    public DateSelector$$ExternalSyntheticLambda0(EditText[] arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onFocusChange(View arg1, boolean arg2) {
        DateSelector.lambda$showKeyboardWithAutoHideBehavior$0(this.f$0, arg1, arg2);
    }
}

