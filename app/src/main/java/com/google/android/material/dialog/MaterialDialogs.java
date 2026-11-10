package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialDialogs {
    private MaterialDialogs() {
        super();
    }

    public static Rect getDialogBackgroundInsets(Context arg7, int arg8, int arg9) {
        Context v0 = arg7;
        TypedArray v7 = ThemeEnforcement.obtainStyledAttributes(v0, null, styleable.MaterialAlertDialog, arg8, arg9, new int[0]);
        arg8 = v7.getDimensionPixelSize(styleable.MaterialAlertDialog_backgroundInsetStart, v0.getResources().getDimensionPixelSize(dimen.mtrl_alert_dialog_background_inset_start));
        arg9 = v7.getDimensionPixelSize(styleable.MaterialAlertDialog_backgroundInsetTop, v0.getResources().getDimensionPixelSize(dimen.mtrl_alert_dialog_background_inset_top));
        int v1 = v7.getDimensionPixelSize(styleable.MaterialAlertDialog_backgroundInsetEnd, v0.getResources().getDimensionPixelSize(dimen.mtrl_alert_dialog_background_inset_end));
        int v2 = v7.getDimensionPixelSize(styleable.MaterialAlertDialog_backgroundInsetBottom, v0.getResources().getDimensionPixelSize(dimen.mtrl_alert_dialog_background_inset_bottom));
        v7.recycle();
        if(v0.getResources().getConfiguration().getLayoutDirection() == 1) {
            int v6 = v1;
            v1 = arg8;
            arg8 = v6;
        }

        return new Rect(arg8, arg9, v1, v2);
    }

    public static InsetDrawable insetDrawable(Drawable arg6, Rect arg7) {
        return new InsetDrawable(arg6, arg7.left, arg7.top, arg7.right, arg7.bottom);
    }
}

