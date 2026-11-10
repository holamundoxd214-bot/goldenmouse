package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

public class MaterialDividerItemDecoration extends ItemDecoration {
    private static final int DEF_STYLE_RES = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int color;
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private boolean lastItemDecorated;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    static {
        MaterialDividerItemDecoration.DEF_STYLE_RES = style.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDividerItemDecoration(Context arg2, int arg3) {
        this(arg2, null, arg3);
    }

    public MaterialDividerItemDecoration(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, attr.materialDividerStyle, arg4);
    }

    public MaterialDividerItemDecoration(Context arg8, AttributeSet arg9, int arg10, int arg11) {
        super();
        this.tempRect = new Rect();
        Context v1 = arg8;
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v1, arg9, styleable.MaterialDivider, arg10, MaterialDividerItemDecoration.DEF_STYLE_RES, new int[0]);
        this.color = MaterialResources.getColorStateList(v1, v8, styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = v8.getDimensionPixelSize(styleable.MaterialDivider_dividerThickness, v1.getResources().getDimensionPixelSize(dimen.material_divider_thickness));
        this.insetStart = v8.getDimensionPixelOffset(styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = v8.getDimensionPixelOffset(styleable.MaterialDivider_dividerInsetEnd, 0);
        this.lastItemDecorated = v8.getBoolean(styleable.MaterialDivider_lastItemDecorated, true);
        v8.recycle();
        this.dividerDrawable = new ShapeDrawable();
        this.setDividerColor(this.color);
        this.setOrientation(arg11);
    }

    private void drawForHorizontalOrientation(Canvas arg9, RecyclerView arg10) {
        int v6_1;
        int v2;
        int v0;
        arg9.save();
        int v1 = 0;
        if(arg10.getClipToPadding()) {
            v0 = arg10.getPaddingTop();
            v2 = arg10.getHeight() - arg10.getPaddingBottom();
            arg9.clipRect(arg10.getPaddingLeft(), v0, arg10.getWidth() - arg10.getPaddingRight(), v2);
        }
        else {
            v2 = arg10.getHeight();
            v0 = 0;
        }

        v0 += this.insetStart;
        v2 -= this.insetEnd;
        boolean v3 = ViewUtils.isLayoutRtl(((View)arg10));
        int v4 = arg10.getChildCount();
        while(v1 < v4) {
            View v5 = arg10.getChildAt(v1);
            if(this.shouldDrawDivider(arg10, v5)) {
                arg10.getLayoutManager().getDecoratedBoundsWithMargins(v5, this.tempRect);
                int v5_1 = Math.round(v5.getTranslationX());
                Rect v6 = this.tempRect;
                if(v3) {
                    v6_1 = v6.left + v5_1;
                    v5_1 = this.thickness + v6_1;
                }
                else {
                    v5_1 += v6.right;
                    v6_1 = v5_1 - this.thickness;
                }

                this.dividerDrawable.setBounds(v6_1, v0, v5_1, v2);
                this.dividerDrawable.draw(arg9);
            }

            ++v1;
        }

        arg9.restore();
    }

    private void drawForVerticalOrientation(Canvas arg8, RecyclerView arg9) {
        int v2;
        int v0;
        arg8.save();
        int v1 = 0;
        if(arg9.getClipToPadding()) {
            v0 = arg9.getPaddingLeft();
            v2 = arg9.getWidth() - arg9.getPaddingRight();
            arg8.clipRect(v0, arg9.getPaddingTop(), v2, arg9.getHeight() - arg9.getPaddingBottom());
        }
        else {
            v2 = arg9.getWidth();
            v0 = 0;
        }

        boolean v3 = ViewUtils.isLayoutRtl(((View)arg9));
        int v4 = v3 ? this.insetEnd : this.insetStart;
        v0 += v4;
        int v3_1 = v3 ? this.insetStart : this.insetEnd;
        v2 -= v3_1;
        v3_1 = arg9.getChildCount();
        while(v1 < v3_1) {
            View v4_1 = arg9.getChildAt(v1);
            if(this.shouldDrawDivider(arg9, v4_1)) {
                arg9.getLayoutManager().getDecoratedBoundsWithMargins(v4_1, this.tempRect);
                int v5 = this.tempRect.bottom + Math.round(v4_1.getTranslationY());
                this.dividerDrawable.setBounds(v0, v5 - this.thickness, v2, v5);
                this.dividerDrawable.draw(arg8);
            }

            ++v1;
        }

        arg8.restore();
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

    public void getItemOffsets(Rect arg1, View arg2, RecyclerView arg3, State arg4) {
        arg1.set(0, 0, 0, 0);
        if(this.shouldDrawDivider(arg3, arg2)) {
            if(this.orientation == 1) {
                arg1.bottom = this.thickness;
                return;
            }
            else {
                boolean v2 = ViewUtils.isLayoutRtl(((View)arg3));
                int v0 = this.thickness;
                if(v2) {
                    arg1.left = v0;
                    return;
                }
                else {
                    arg1.right = v0;
                }
            }
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isLastItemDecorated() {
        return this.lastItemDecorated;
    }

    public void onDraw(Canvas arg2, RecyclerView arg3, State arg4) {
        if(arg3.getLayoutManager() == null) {
            return;
        }

        if(this.orientation == 1) {
            this.drawForVerticalOrientation(arg2, arg3);
            return;
        }

        this.drawForHorizontalOrientation(arg2, arg3);
    }

    public void setDividerColor(int arg2) {
        this.color = arg2;
        Drawable v0 = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = v0;
        DrawableCompat.setTint(v0, arg2);
    }

    public void setDividerColorResource(Context arg1, int arg2) {
        this.setDividerColor(ContextCompat.getColor(arg1, arg2));
    }

    public void setDividerInsetEnd(int arg1) {
        this.insetEnd = arg1;
    }

    public void setDividerInsetEndResource(Context arg1, int arg2) {
        this.setDividerInsetEnd(arg1.getResources().getDimensionPixelOffset(arg2));
    }

    public void setDividerInsetStart(int arg1) {
        this.insetStart = arg1;
    }

    public void setDividerInsetStartResource(Context arg1, int arg2) {
        this.setDividerInsetStart(arg1.getResources().getDimensionPixelOffset(arg2));
    }

    public void setDividerThickness(int arg1) {
        this.thickness = arg1;
    }

    public void setDividerThicknessResource(Context arg1, int arg2) {
        this.setDividerThickness(arg1.getResources().getDimensionPixelSize(arg2));
    }

    public void setLastItemDecorated(boolean arg1) {
        this.lastItemDecorated = arg1;
    }

    public void setOrientation(int arg3) {
        if(arg3 != 0) {
            if(arg3 == 1) {
            }
            else {
                throw new IllegalArgumentException("Invalid orientation: " + arg3 + ". It should be either HORIZONTAL or VERTICAL");
            }
        }

        this.orientation = arg3;
    }

    private boolean shouldDrawDivider(RecyclerView arg5, View arg6) {
        int v6 = arg5.getChildAdapterPosition(arg6);
        Adapter v5 = arg5.getAdapter();
        int v2 = v5 == null || v6 != v5.getItemCount() - 1 ? 0 : 1;
        if(v6 != -1 && (v2 == 0 || (this.lastItemDecorated)) && (this.shouldDrawDivider(v6, v5))) {
            return 1;
        }

        return 0;
    }

    protected boolean shouldDrawDivider(int arg1, Adapter arg2) {
        return 1;
    }
}

