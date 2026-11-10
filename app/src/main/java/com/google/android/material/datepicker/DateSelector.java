package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View$OnFocusChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.Collection;

public interface DateSelector extends Parcelable {
    int getDefaultThemeResId(Context arg1);

    int getDefaultTitleResId();

    String getError();

    Collection getSelectedDays();

    Collection getSelectedRanges();

    Object getSelection();

    String getSelectionContentDescription(Context arg1);

    String getSelectionDisplayString(Context arg1);

    boolean isSelectionComplete();

    static void lambda$showKeyboardWithAutoHideBehavior$0(EditText[] arg3, View arg4, boolean arg5) {
        int v5 = arg3.length;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            if(arg3[v1].hasFocus()) {
                return;
            }
        }

        ViewUtils.hideKeyboard(arg4, false);
    }

    static void lambda$showKeyboardWithAutoHideBehavior$1(View arg1) {
        ViewUtils.requestFocusAndShowKeyboard(arg1, false);
    }

    View onCreateTextInputView(LayoutInflater arg1, ViewGroup arg2, Bundle arg3, CalendarConstraints arg4, OnSelectionChangedListener arg5);

    void select(long arg1);

    void setSelection(Object arg1);

    void setTextInputFormat(SimpleDateFormat arg1);

    static void showKeyboardWithAutoHideBehavior(EditText[] arg5) {
        if(arg5.length == 0) {
            return;
        }

        DateSelector$$ExternalSyntheticLambda0 v0 = new DateSelector$$ExternalSyntheticLambda0(arg5);
        int v1 = arg5.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            arg5[v3].setOnFocusChangeListener(((View$OnFocusChangeListener)v0));
        }

        arg5[0].postDelayed(new DateSelector$$ExternalSyntheticLambda1(arg5[0]), 100);
    }
}

