package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R$string;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private int lastLength;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    private final TextInputLayout textInputLayout;

    DateFormatTextWatcher(String arg2, DateFormat arg3, TextInputLayout arg4, CalendarConstraints arg5) {
        super();
        this.lastLength = 0;
        this.formatHint = arg2;
        this.dateFormat = arg3;
        this.textInputLayout = arg4;
        this.constraints = arg5;
        this.outOfRange = arg4.getContext().getString(string.mtrl_picker_out_of_range);
        this.setErrorCallback = new DateFormatTextWatcher$$ExternalSyntheticLambda0(this, arg2);
    }

    public void afterTextChanged(Editable arg3) {
        if(Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
        }
        else if(arg3.length() != 0 && arg3.length() < this.formatHint.length()) {
            if(arg3.length() < this.lastLength) {
            }
            else {
                char v2 = this.formatHint.charAt(arg3.length());
                if(!Character.isDigit(v2)) {
                    arg3.append(v2);
                }
            }
        }
    }

    public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
        this.lastLength = arg1.length();
    }

    private Runnable createRangeErrorCallback(long arg2) {
        return new DateFormatTextWatcher$$ExternalSyntheticLambda1(this, arg2);
    }

    void lambda$createRangeErrorCallback$1$com-google-android-material-datepicker-DateFormatTextWatcher(long arg2) {
        this.textInputLayout.setError(String.format(this.outOfRange, this.sanitizeDateString(DateStrings.getDateString(arg2))));
        this.onInvalidDate();
    }

    void lambda$new$0$com-google-android-material-datepicker-DateFormatTextWatcher(String arg8) {
        TextInputLayout v0 = this.textInputLayout;
        DateFormat v1 = this.dateFormat;
        Context v2 = v0.getContext();
        v0.setError(v2.getString(string.mtrl_picker_invalid_format) + "\n" + String.format(v2.getString(string.mtrl_picker_invalid_format_use), this.sanitizeDateString(arg8)) + "\n" + String.format(v2.getString(string.mtrl_picker_invalid_format_example), this.sanitizeDateString(v1.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())))));
        this.onInvalidDate();
    }

    void onInvalidDate() {
    }

    public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        CharSequence v3 = null;
        this.textInputLayout.setError(v3);
        this.onValidDate(((Long)v3));
        if(!TextUtils.isEmpty(arg1) && arg1.length() >= this.formatHint.length()) {
            try {
                Date v1 = this.dateFormat.parse(arg1.toString());
                this.textInputLayout.setError(v3);
                long v2 = v1.getTime();
                if((this.constraints.getDateValidator().isValid(v2)) && (this.constraints.isWithinBounds(v2))) {
                    this.onValidDate(Long.valueOf(v1.getTime()));
                    return;
                }

                Runnable v1_1 = this.createRangeErrorCallback(v2);
                this.setRangeErrorCallback = v1_1;
                this.runValidation(this.textInputLayout, v1_1);
                return;
            }
            catch(ParseException ) {
                this.runValidation(this.textInputLayout, this.setErrorCallback);
            }
        }
    }

    abstract void onValidDate(Long arg1);

    public void runValidation(View arg1, Runnable arg2) {
        arg1.post(arg2);
    }

    private String sanitizeDateString(String arg2) {
        return arg2.replace(' ', ' ');
    }
}

