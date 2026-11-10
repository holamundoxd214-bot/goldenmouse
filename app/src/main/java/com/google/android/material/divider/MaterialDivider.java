package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES;
    private int color;
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    static {
        MaterialDivider.DEF_STYLE_RES = style.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDivider(Context arg2) {
        this(arg2, null);
    }

    public MaterialDivider(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialDividerStyle);
    }

    public MaterialDivider(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = MaterialDivider.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        Context v0 = this.getContext();
        this.dividerDrawable = new MaterialShapeDrawable();
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg8, styleable.MaterialDivider, arg9, v4, new int[0]);
        this.thickness = v8.getDimensionPixelSize(styleable.MaterialDivider_dividerThickness, this.getResources().getDimensionPixelSize(dimen.material_divider_thickness));
        this.insetStart = v8.getDimensionPixelOffset(styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = v8.getDimensionPixelOffset(styleable.MaterialDivider_dividerInsetEnd, 0);
        this.setDividerColor(MaterialResources.getColorStateList(v0, v8, styleable.MaterialDivider_dividerColor).getDefaultColor());
        v8.recycle();
    }

    public int getDividerColor() {
        return this.color;
    }

    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    protected void onDraw(Canvas arg7) {
        int v3;
        super.onDraw(arg7);
        int v2 = 1;
        if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
        }
        else {
            v2 = 0;
        }

        int v0 = v2 != 0 ? this.insetEnd : this.insetStart;
        if(v2 != 0) {
            v2 = this.getWidth();
            v3 = this.insetStart;
        }
        else {
            v2 = this.getWidth();
            v3 = this.insetEnd;
        }

        this.dividerDrawable.setBounds(v0, 0, v2 - v3, this.getBottom() - this.getTop());
        this.dividerDrawable.draw(arg7);
    }

    protected void onMeasure(int arg2, int arg3) {
        super.onMeasure(arg2, arg3);
        arg2 = View$MeasureSpec.getMode(arg3);
        arg3 = this.getMeasuredHeight();
        if(arg2 != 0x80000000) {
            if(arg2 == 0) {
            }
            else {
                return;
            }
        }

        arg2 = this.thickness;
        if(arg2 > 0 && arg3 != arg2) {
            arg3 = arg2;
        }

        this.setMeasuredDimension(this.getMeasuredWidth(), arg3);
    }

    public void setDividerColor(int arg2) {
        if(this.color != arg2) {
            this.color = arg2;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(arg2));
            this.invalidate();
        }
    }

    public void setDividerColorResource(int arg2) {
        this.setDividerColor(ContextCompat.getColor(this.getContext(), arg2));
    }

    public void setDividerInsetEnd(int arg1) {
        this.insetEnd = arg1;
    }

    public void setDividerInsetEndResource(int arg2) {
        this.setDividerInsetEnd(this.getContext().getResources().getDimensionPixelOffset(arg2));
    }

    public void setDividerInsetStart(int arg1) {
        this.insetStart = arg1;
    }

    public void setDividerInsetStartResource(int arg2) {
        this.setDividerInsetStart(this.getContext().getResources().getDimensionPixelOffset(arg2));
    }

    public void setDividerThickness(int arg2) {
        if(this.thickness != arg2) {
            this.thickness = arg2;
            this.requestLayout();
        }
    }

    public void setDividerThicknessResource(int arg2) {
        this.setDividerThickness(this.getContext().getResources().getDimensionPixelSize(arg2));
    }
}

