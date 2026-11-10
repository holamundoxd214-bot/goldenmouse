package com.google.android.material.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAlertDialogBuilder extends Builder {
    private static final int DEF_STYLE_ATTR;
    private static final int DEF_STYLE_RES;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY;
    private Drawable background;
    private final Rect backgroundInsets;

    static {
        MaterialAlertDialogBuilder.DEF_STYLE_ATTR = attr.alertDialogStyle;
        MaterialAlertDialogBuilder.DEF_STYLE_RES = style.MaterialAlertDialog_MaterialComponents;
        MaterialAlertDialogBuilder.MATERIAL_ALERT_DIALOG_THEME_OVERLAY = attr.materialAlertDialogTheme;
    }

    public MaterialAlertDialogBuilder(Context arg2) {
        this(arg2, 0);
    }

    public MaterialAlertDialogBuilder(Context arg7, int arg8) {
        super(MaterialAlertDialogBuilder.createMaterialAlertDialogThemedContext(arg7), MaterialAlertDialogBuilder.getOverridingThemeResId(arg7, arg8));
        arg7 = this.getContext();
        Resources$Theme v8 = arg7.getTheme();
        int v0 = MaterialAlertDialogBuilder.DEF_STYLE_ATTR;
        int v1 = MaterialAlertDialogBuilder.DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(arg7, v0, v1);
        int v2 = MaterialColors.getColor(arg7, attr.colorSurface, this.getClass().getCanonicalName());
        TypedArray v3 = arg7.obtainStyledAttributes(null, styleable.MaterialAlertDialog, v0, v1);
        v2 = v3.getColor(styleable.MaterialAlertDialog_backgroundTint, v2);
        v3.recycle();
        MaterialShapeDrawable v3_1 = new MaterialShapeDrawable(arg7, null, v0, v1);
        v3_1.initializeElevationOverlay(arg7);
        v3_1.setFillColor(ColorStateList.valueOf(v2));
        if(Build$VERSION.SDK_INT >= 28) {
            TypedValue v7 = new TypedValue();
            v8.resolveAttribute(0x1010571, v7, true);
            float v8_1 = v7.getDimension(this.getContext().getResources().getDisplayMetrics());
            if(v7.type == 5 && v8_1 >= 0f) {
                v3_1.setCornerSize(v8_1);
            }
        }

        this.background = ((Drawable)v3_1);
    }

    public AlertDialog create() {
        AlertDialog v0 = super.create();
        Window v1 = v0.getWindow();
        View v2 = v1.getDecorView();
        Drawable v3 = this.background;
        if((v3 instanceof MaterialShapeDrawable)) {
            ((MaterialShapeDrawable)v3).setElevation(ViewCompat.getElevation(v2));
        }

        v1.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        v2.setOnTouchListener(new InsetDialogOnTouchListener(((Dialog)v0), this.backgroundInsets));
        return v0;
    }

    private static Context createMaterialAlertDialogThemedContext(Context arg4) {
        int v0 = MaterialAlertDialogBuilder.getMaterialAlertDialogThemeOverlay(arg4);
        arg4 = MaterialThemeOverlay.wrap(arg4, null, MaterialAlertDialogBuilder.DEF_STYLE_ATTR, MaterialAlertDialogBuilder.DEF_STYLE_RES);
        if(v0 == 0) {
            return arg4;
        }

        return new ContextThemeWrapper(arg4, v0);
    }

    public Drawable getBackground() {
        return this.background;
    }

    private static int getMaterialAlertDialogThemeOverlay(Context arg1) {
        TypedValue v1 = MaterialAttributes.resolve(arg1, MaterialAlertDialogBuilder.MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if(v1 == null) {
            return 0;
        }

        return v1.data;
    }

    private static int getOverridingThemeResId(Context arg0, int arg1) {
        if(arg1 == 0) {
            return MaterialAlertDialogBuilder.getMaterialAlertDialogThemeOverlay(arg0);
        }

        return arg1;
    }

    public Builder setAdapter(ListAdapter arg1, DialogInterface$OnClickListener arg2) {
        return this.setAdapter(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setAdapter(ListAdapter arg1, DialogInterface$OnClickListener arg2) {
        return super.setAdapter(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setBackground(Drawable arg1) {
        this.background = arg1;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int arg2) {
        this.backgroundInsets.bottom = arg2;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int arg4) {
        int v0 = this.getContext().getResources().getConfiguration().getLayoutDirection();
        Rect v1 = this.backgroundInsets;
        if(v0 == 1) {
            v1.left = arg4;
            return this;
        }

        v1.right = arg4;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int arg4) {
        int v0 = this.getContext().getResources().getConfiguration().getLayoutDirection();
        Rect v1 = this.backgroundInsets;
        if(v0 == 1) {
            v1.right = arg4;
            return this;
        }

        v1.left = arg4;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int arg2) {
        this.backgroundInsets.top = arg2;
        return this;
    }

    public Builder setCancelable(boolean arg1) {
        return this.setCancelable(arg1);
    }

    public MaterialAlertDialogBuilder setCancelable(boolean arg1) {
        return super.setCancelable(arg1);
    }

    public Builder setCursor(Cursor arg1, DialogInterface$OnClickListener arg2, String arg3) {
        return this.setCursor(arg1, arg2, arg3);
    }

    public MaterialAlertDialogBuilder setCursor(Cursor arg1, DialogInterface$OnClickListener arg2, String arg3) {
        return super.setCursor(arg1, arg2, arg3);
    }

    public Builder setCustomTitle(View arg1) {
        return this.setCustomTitle(arg1);
    }

    public MaterialAlertDialogBuilder setCustomTitle(View arg1) {
        return super.setCustomTitle(arg1);
    }

    public Builder setIcon(int arg1) {
        return this.setIcon(arg1);
    }

    public MaterialAlertDialogBuilder setIcon(int arg1) {
        return super.setIcon(arg1);
    }

    public Builder setIcon(Drawable arg1) {
        return this.setIcon(arg1);
    }

    public MaterialAlertDialogBuilder setIcon(Drawable arg1) {
        return super.setIcon(arg1);
    }

    public Builder setIconAttribute(int arg1) {
        return this.setIconAttribute(arg1);
    }

    public MaterialAlertDialogBuilder setIconAttribute(int arg1) {
        return super.setIconAttribute(arg1);
    }

    public Builder setItems(int arg1, DialogInterface$OnClickListener arg2) {
        return this.setItems(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setItems(int arg1, DialogInterface$OnClickListener arg2) {
        return super.setItems(arg1, arg2);
    }

    public Builder setItems(CharSequence[] arg1, DialogInterface$OnClickListener arg2) {
        return this.setItems(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setItems(CharSequence[] arg1, DialogInterface$OnClickListener arg2) {
        return super.setItems(arg1, arg2);
    }

    public Builder setMessage(int arg1) {
        return this.setMessage(arg1);
    }

    public MaterialAlertDialogBuilder setMessage(int arg1) {
        return super.setMessage(arg1);
    }

    public Builder setMessage(CharSequence arg1) {
        return this.setMessage(arg1);
    }

    public MaterialAlertDialogBuilder setMessage(CharSequence arg1) {
        return super.setMessage(arg1);
    }

    public Builder setMultiChoiceItems(int arg1, boolean[] arg2, DialogInterface$OnMultiChoiceClickListener arg3) {
        return this.setMultiChoiceItems(arg1, arg2, arg3);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(int arg1, boolean[] arg2, DialogInterface$OnMultiChoiceClickListener arg3) {
        return super.setMultiChoiceItems(arg1, arg2, arg3);
    }

    public Builder setMultiChoiceItems(Cursor arg1, String arg2, String arg3, DialogInterface$OnMultiChoiceClickListener arg4) {
        return this.setMultiChoiceItems(arg1, arg2, arg3, arg4);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor arg1, String arg2, String arg3, DialogInterface$OnMultiChoiceClickListener arg4) {
        return super.setMultiChoiceItems(arg1, arg2, arg3, arg4);
    }

    public Builder setMultiChoiceItems(CharSequence[] arg1, boolean[] arg2, DialogInterface$OnMultiChoiceClickListener arg3) {
        return this.setMultiChoiceItems(arg1, arg2, arg3);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] arg1, boolean[] arg2, DialogInterface$OnMultiChoiceClickListener arg3) {
        return super.setMultiChoiceItems(arg1, arg2, arg3);
    }

    public Builder setNegativeButton(int arg1, DialogInterface$OnClickListener arg2) {
        return this.setNegativeButton(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setNegativeButton(int arg1, DialogInterface$OnClickListener arg2) {
        return super.setNegativeButton(arg1, arg2);
    }

    public Builder setNegativeButton(CharSequence arg1, DialogInterface$OnClickListener arg2) {
        return this.setNegativeButton(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setNegativeButton(CharSequence arg1, DialogInterface$OnClickListener arg2) {
        return super.setNegativeButton(arg1, arg2);
    }

    public Builder setNegativeButtonIcon(Drawable arg1) {
        return this.setNegativeButtonIcon(arg1);
    }

    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable arg1) {
        return super.setNegativeButtonIcon(arg1);
    }

    public Builder setNeutralButton(int arg1, DialogInterface$OnClickListener arg2) {
        return this.setNeutralButton(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setNeutralButton(int arg1, DialogInterface$OnClickListener arg2) {
        return super.setNeutralButton(arg1, arg2);
    }

    public Builder setNeutralButton(CharSequence arg1, DialogInterface$OnClickListener arg2) {
        return this.setNeutralButton(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setNeutralButton(CharSequence arg1, DialogInterface$OnClickListener arg2) {
        return super.setNeutralButton(arg1, arg2);
    }

    public Builder setNeutralButtonIcon(Drawable arg1) {
        return this.setNeutralButtonIcon(arg1);
    }

    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable arg1) {
        return super.setNeutralButtonIcon(arg1);
    }

    public Builder setOnCancelListener(DialogInterface$OnCancelListener arg1) {
        return this.setOnCancelListener(arg1);
    }

    public MaterialAlertDialogBuilder setOnCancelListener(DialogInterface$OnCancelListener arg1) {
        return super.setOnCancelListener(arg1);
    }

    public Builder setOnDismissListener(DialogInterface$OnDismissListener arg1) {
        return this.setOnDismissListener(arg1);
    }

    public MaterialAlertDialogBuilder setOnDismissListener(DialogInterface$OnDismissListener arg1) {
        return super.setOnDismissListener(arg1);
    }

    public Builder setOnItemSelectedListener(AdapterView$OnItemSelectedListener arg1) {
        return this.setOnItemSelectedListener(arg1);
    }

    public MaterialAlertDialogBuilder setOnItemSelectedListener(AdapterView$OnItemSelectedListener arg1) {
        return super.setOnItemSelectedListener(arg1);
    }

    public Builder setOnKeyListener(DialogInterface$OnKeyListener arg1) {
        return this.setOnKeyListener(arg1);
    }

    public MaterialAlertDialogBuilder setOnKeyListener(DialogInterface$OnKeyListener arg1) {
        return super.setOnKeyListener(arg1);
    }

    public Builder setPositiveButton(int arg1, DialogInterface$OnClickListener arg2) {
        return this.setPositiveButton(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setPositiveButton(int arg1, DialogInterface$OnClickListener arg2) {
        return super.setPositiveButton(arg1, arg2);
    }

    public Builder setPositiveButton(CharSequence arg1, DialogInterface$OnClickListener arg2) {
        return this.setPositiveButton(arg1, arg2);
    }

    public MaterialAlertDialogBuilder setPositiveButton(CharSequence arg1, DialogInterface$OnClickListener arg2) {
        return super.setPositiveButton(arg1, arg2);
    }

    public Builder setPositiveButtonIcon(Drawable arg1) {
        return this.setPositiveButtonIcon(arg1);
    }

    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable arg1) {
        return super.setPositiveButtonIcon(arg1);
    }

    public Builder setSingleChoiceItems(int arg1, int arg2, DialogInterface$OnClickListener arg3) {
        return this.setSingleChoiceItems(arg1, arg2, arg3);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(int arg1, int arg2, DialogInterface$OnClickListener arg3) {
        return super.setSingleChoiceItems(arg1, arg2, arg3);
    }

    public Builder setSingleChoiceItems(Cursor arg1, int arg2, String arg3, DialogInterface$OnClickListener arg4) {
        return this.setSingleChoiceItems(arg1, arg2, arg3, arg4);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor arg1, int arg2, String arg3, DialogInterface$OnClickListener arg4) {
        return super.setSingleChoiceItems(arg1, arg2, arg3, arg4);
    }

    public Builder setSingleChoiceItems(ListAdapter arg1, int arg2, DialogInterface$OnClickListener arg3) {
        return this.setSingleChoiceItems(arg1, arg2, arg3);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter arg1, int arg2, DialogInterface$OnClickListener arg3) {
        return super.setSingleChoiceItems(arg1, arg2, arg3);
    }

    public Builder setSingleChoiceItems(CharSequence[] arg1, int arg2, DialogInterface$OnClickListener arg3) {
        return this.setSingleChoiceItems(arg1, arg2, arg3);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] arg1, int arg2, DialogInterface$OnClickListener arg3) {
        return super.setSingleChoiceItems(arg1, arg2, arg3);
    }

    public Builder setTitle(int arg1) {
        return this.setTitle(arg1);
    }

    public MaterialAlertDialogBuilder setTitle(int arg1) {
        return super.setTitle(arg1);
    }

    public Builder setTitle(CharSequence arg1) {
        return this.setTitle(arg1);
    }

    public MaterialAlertDialogBuilder setTitle(CharSequence arg1) {
        return super.setTitle(arg1);
    }

    public Builder setView(int arg1) {
        return this.setView(arg1);
    }

    public MaterialAlertDialogBuilder setView(int arg1) {
        return super.setView(arg1);
    }

    public Builder setView(View arg1) {
        return this.setView(arg1);
    }

    public MaterialAlertDialogBuilder setView(View arg1) {
        return super.setView(arg1);
    }
}

