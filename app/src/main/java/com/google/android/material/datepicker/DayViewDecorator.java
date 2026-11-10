package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

public abstract class DayViewDecorator implements Parcelable {
    public DayViewDecorator() {
        super();
    }

    public ColorStateList getBackgroundColor(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return null;
    }

    public Drawable getCompoundDrawableBottom(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return null;
    }

    public Drawable getCompoundDrawableLeft(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return null;
    }

    public Drawable getCompoundDrawableRight(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return null;
    }

    public Drawable getCompoundDrawableTop(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return null;
    }

    public CharSequence getContentDescription(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6, CharSequence arg7) {
        return arg7;
    }

    public ColorStateList getTextColor(Context arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        return null;
    }

    public void initialize(Context arg1) {
    }
}

