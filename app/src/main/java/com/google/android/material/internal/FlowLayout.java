package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;

public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(Context arg2) {
        this(arg2, null);
    }

    public FlowLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public FlowLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.singleLine = false;
        this.loadFromAttributes(arg1, arg2);
    }

    public FlowLayout(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.singleLine = false;
        this.loadFromAttributes(arg1, arg2);
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    private static int getMeasuredDimension(int arg1, int arg2, int arg3) {
        if(arg2 != 0x80000000) {
            if(arg2 != 0x40000000) {
                return arg3;
            }

            return arg1;
        }

        return Math.min(arg3, arg1);
    }

    protected int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(View arg1) {
        Object v0 = arg1.getTag(id.row_index_key);
        if(!(v0 instanceof Integer)) {
            return -1;
        }

        return ((Integer)v0).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    private void loadFromAttributes(Context arg3, AttributeSet arg4) {
        TypedArray v3 = arg3.getTheme().obtainStyledAttributes(arg4, styleable.FlowLayout, 0, 0);
        this.lineSpacing = v3.getDimensionPixelSize(styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = v3.getDimensionPixelSize(styleable.FlowLayout_itemSpacing, 0);
        v3.recycle();
    }

    protected void onLayout(boolean arg10, int arg11, int arg12, int arg13, int arg14) {
        int v5_1;
        int v6;
        if(this.getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }

        this.rowCount = 1;
        arg14 = ViewCompat.getLayoutDirection(((View)this)) == 1 ? 1 : 0;
        int v0 = arg14 != 0 ? this.getPaddingRight() : this.getPaddingLeft();
        int v1 = arg14 != 0 ? this.getPaddingLeft() : this.getPaddingRight();
        int v2 = this.getPaddingTop();
        arg13 = arg13 - arg11 - v1;
        v1 = 0;
        int v3 = v0;
        arg11 = v2;
        while(v1 < this.getChildCount()) {
            View v4 = this.getChildAt(v1);
            if(v4.getVisibility() == 8) {
                v4.setTag(id.row_index_key, Integer.valueOf(-1));
            }
            else {
                ViewGroup$LayoutParams v5 = v4.getLayoutParams();
                if((v5 instanceof ViewGroup$MarginLayoutParams)) {
                    v6 = MarginLayoutParamsCompat.getMarginStart(((ViewGroup$MarginLayoutParams)v5));
                    v5_1 = MarginLayoutParamsCompat.getMarginEnd(((ViewGroup$MarginLayoutParams)v5));
                }
                else {
                    v5_1 = 0;
                    v6 = 0;
                }

                int v7 = v3 + v6 + v4.getMeasuredWidth();
                if(!this.singleLine && v7 > arg13) {
                    arg11 = this.lineSpacing + v2;
                    ++this.rowCount;
                    v3 = v0;
                }

                v4.setTag(id.row_index_key, Integer.valueOf(this.rowCount - 1));
                v2 = v3 + v6;
                v7 = v4.getMeasuredWidth() + v2;
                int v8 = v4.getMeasuredHeight() + arg11;
                if(arg14 != 0) {
                    v4.layout(arg13 - v7, arg11, arg13 - v3 - v6, v8);
                }
                else {
                    v4.layout(v2, arg11, v7, v8);
                }

                v3 += v6 + v5_1 + v4.getMeasuredWidth() + this.itemSpacing;
                v2 = v8;
            }

            ++v1;
        }
    }

    protected void onMeasure(int arg20, int arg21) {
        int v15_1;
        int v8;
        FlowLayout v0 = this;
        int v1 = View$MeasureSpec.getSize(arg20);
        int v2 = View$MeasureSpec.getMode(arg20);
        int v3 = View$MeasureSpec.getSize(arg21);
        int v4 = View$MeasureSpec.getMode(arg21);
        int v5 = v2 == 0x80000000 || v2 == 0x40000000 ? v1 : 0x7FFFFFFF;
        int v6 = v0.getPaddingLeft();
        int v7 = v0.getPaddingTop();
        v5 -= v0.getPaddingRight();
        int v9 = v7;
        int v10 = 0;
        int v11 = 0;
        while(v10 < v0.getChildCount()) {
            View v12 = v0.getChildAt(v10);
            if(v12.getVisibility() == 8) {
            }
            else {
                v0.measureChild(v12, arg20, arg21);
                ViewGroup$LayoutParams v15 = v12.getLayoutParams();
                if((v15 instanceof ViewGroup$MarginLayoutParams)) {
                    v8 = ((ViewGroup$MarginLayoutParams)v15).leftMargin;
                    v15_1 = ((ViewGroup$MarginLayoutParams)v15).rightMargin;
                }
                else {
                    v8 = 0;
                    v15_1 = 0;
                }

                int v18 = v6;
                if(v6 + v8 + v12.getMeasuredWidth() <= v5 || (v0.isSingleLine())) {
                    v6 = v18;
                }
                else {
                    v6 = v0.getPaddingLeft();
                    v9 = v0.lineSpacing + v7;
                }

                v7 = v6 + v8 + v12.getMeasuredWidth();
                int v16 = v9 + v12.getMeasuredHeight();
                if(v7 > v11) {
                    v11 = v7;
                }

                v6 += v8 + v15_1 + v12.getMeasuredWidth() + v0.itemSpacing;
                if(v10 == v0.getChildCount() - 1) {
                    v11 += v15_1;
                }

                v7 = v16;
            }

            ++v10;
        }

        v0.setMeasuredDimension(FlowLayout.getMeasuredDimension(v1, v2, v11 + v0.getPaddingRight()), FlowLayout.getMeasuredDimension(v3, v4, v7 + v0.getPaddingBottom()));
    }

    protected void setItemSpacing(int arg1) {
        this.itemSpacing = arg1;
    }

    protected void setLineSpacing(int arg1) {
        this.lineSpacing = arg1;
    }

    public void setSingleLine(boolean arg1) {
        this.singleLine = arg1;
    }
}

