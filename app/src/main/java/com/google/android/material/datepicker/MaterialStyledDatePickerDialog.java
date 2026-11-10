package com.google.android.material.datepicker;

import android.app.DatePickerDialog$OnDateSetListener;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    private static final int DEF_STYLE_ATTR = 0x101035C;
    private static final int DEF_STYLE_RES;
    private final Drawable background;
    private final Rect backgroundInsets;

    static {
        MaterialStyledDatePickerDialog.DEF_STYLE_RES = style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    }

    public MaterialStyledDatePickerDialog(Context arg2) {
        this(arg2, 0);
    }

    public MaterialStyledDatePickerDialog(Context arg8, int arg9) {
        this(arg8, arg9, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(Context arg1, int arg2, DatePickerDialog$OnDateSetListener arg3, int arg4, int arg5, int arg6) {
        super(arg1, arg2, arg3, arg4, arg5, arg6);
        arg1 = this.getContext();
        arg2 = MaterialAttributes.resolveOrThrow(this.getContext(), attr.colorSurface, this.getClass().getCanonicalName());
        arg4 = MaterialStyledDatePickerDialog.DEF_STYLE_RES;
        MaterialShapeDrawable v3 = new MaterialShapeDrawable(arg1, null, 0x101035C, arg4);
        v3.setFillColor(ColorStateList.valueOf(arg2));
        Rect v1 = MaterialDialogs.getDialogBackgroundInsets(arg1, 0x101035C, arg4);
        this.backgroundInsets = v1;
        this.background = MaterialDialogs.insetDrawable(((Drawable)v3), v1);
    }

    public MaterialStyledDatePickerDialog(Context arg8, DatePickerDialog$OnDateSetListener arg9, int arg10, int arg11, int arg12) {
        this(arg8, 0, arg9, arg10, arg11, arg12);
    }

    protected void onCreate(Bundle arg3) {
        super.onCreate(arg3);
        this.getWindow().setBackgroundDrawable(this.background);
        this.getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(((Dialog)this), this.backgroundInsets));
    }
}

