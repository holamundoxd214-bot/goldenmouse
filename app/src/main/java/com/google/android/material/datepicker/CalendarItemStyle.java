package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

final class CalendarItemStyle {
    private final ColorStateList backgroundColor;
    private final Rect insets;
    private final ShapeAppearanceModel itemShape;
    private final ColorStateList strokeColor;
    private final int strokeWidth;
    private final ColorStateList textColor;

    private CalendarItemStyle(ColorStateList arg2, ColorStateList arg3, ColorStateList arg4, int arg5, ShapeAppearanceModel arg6, Rect arg7) {
        super();
        Preconditions.checkArgumentNonnegative(arg7.left);
        Preconditions.checkArgumentNonnegative(arg7.top);
        Preconditions.checkArgumentNonnegative(arg7.right);
        Preconditions.checkArgumentNonnegative(arg7.bottom);
        this.insets = arg7;
        this.textColor = arg3;
        this.backgroundColor = arg2;
        this.strokeColor = arg4;
        this.strokeWidth = arg5;
        this.itemShape = arg6;
    }

    static CalendarItemStyle create(Context arg12, int arg13) {
        boolean v1 = arg13 != 0 ? true : false;
        Preconditions.checkArgument(v1, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray v13 = arg12.obtainStyledAttributes(arg13, styleable.MaterialCalendarItem);
        Rect v11 = new Rect(v13.getDimensionPixelOffset(styleable.MaterialCalendarItem_android_insetLeft, 0), v13.getDimensionPixelOffset(styleable.MaterialCalendarItem_android_insetTop, 0), v13.getDimensionPixelOffset(styleable.MaterialCalendarItem_android_insetRight, 0), v13.getDimensionPixelOffset(styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList v6 = MaterialResources.getColorStateList(arg12, v13, styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList v7 = MaterialResources.getColorStateList(arg12, v13, styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList v8 = MaterialResources.getColorStateList(arg12, v13, styleable.MaterialCalendarItem_itemStrokeColor);
        int v9 = v13.getDimensionPixelSize(styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel v10 = ShapeAppearanceModel.builder(arg12, v13.getResourceId(styleable.MaterialCalendarItem_itemShapeAppearance, 0), v13.getResourceId(styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        v13.recycle();
        return new CalendarItemStyle(v6, v7, v8, v9, v10, v11);
    }

    int getBottomInset() {
        return this.insets.bottom;
    }

    int getLeftInset() {
        return this.insets.left;
    }

    int getRightInset() {
        return this.insets.right;
    }

    int getTopInset() {
        return this.insets.top;
    }

    void styleItem(TextView arg2) {
        this.styleItem(arg2, null, null);
    }

    void styleItem(TextView arg9, ColorStateList arg10, ColorStateList arg11) {
        MaterialShapeDrawable v0 = new MaterialShapeDrawable();
        MaterialShapeDrawable v1 = new MaterialShapeDrawable();
        v0.setShapeAppearanceModel(this.itemShape);
        v1.setShapeAppearanceModel(this.itemShape);
        if(arg10 != null) {
        }
        else {
            arg10 = this.backgroundColor;
        }

        v0.setFillColor(arg10);
        v0.setStroke(((float)this.strokeWidth), this.strokeColor);
        if(arg11 != null) {
        }
        else {
            arg11 = this.textColor;
        }

        arg9.setTextColor(arg11);
        ViewCompat.setBackground(((View)arg9), new InsetDrawable(new RippleDrawable(this.textColor.withAlpha(30), ((Drawable)v0), ((Drawable)v1)), this.insets.left, this.insets.top, this.insets.right, this.insets.bottom));
    }
}

