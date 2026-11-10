package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int arg1) {
        super();
        this.max = arg1;
    }

    public CharSequence filter(CharSequence arg2, int arg3, int arg4, Spanned arg5, int arg6, int arg7) {
        try {
            StringBuilder v0 = new StringBuilder(((CharSequence)arg5));
            v0.replace(arg6, arg7, arg2.subSequence(arg3, arg4).toString());
            if(Integer.parseInt(v0.toString()) > this.max) {
                return "";
            }
        }
        catch(NumberFormatException ) {
            return "";
        }

        return null;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int arg1) {
        this.max = arg1;
    }
}

