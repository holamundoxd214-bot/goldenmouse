package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private boolean mStacked;

    public ButtonBarLayout(Context arg9, AttributeSet arg10) {
        super(arg9, arg10);
        this.mLastWidthSize = -1;
        TypedArray v5 = arg9.obtainStyledAttributes(arg10, styleable.ButtonBarLayout);
        ButtonBarLayout v1 = this;
        ViewCompat.saveAttributeDataForStyleable(((View)v1), arg9, styleable.ButtonBarLayout, arg10, v5, 0, 0);
        v1.mAllowStacking = v5.getBoolean(styleable.ButtonBarLayout_allowStacking, true);
        v5.recycle();
        if(v1.getOrientation() == 1) {
            v1.setStacked(v1.mAllowStacking);
        }
    }

    private int getNextVisibleChildIndex(int arg3) {
        int v0 = this.getChildCount();
        while(arg3 < v0) {
            if(this.getChildAt(arg3).getVisibility() == 0) {
                return arg3;
            }

            ++arg3;
        }

        return -1;
    }

    private boolean isStacked() {
        return this.mStacked;
    }

    protected void onMeasure(int arg6, int arg7) {
        int v1;
        int v0 = View$MeasureSpec.getSize(arg6);
        int v2 = 0;
        if(this.mAllowStacking) {
            if(v0 > this.mLastWidthSize && (this.isStacked())) {
                this.setStacked(false);
            }

            this.mLastWidthSize = v0;
        }

        if((this.isStacked()) || View$MeasureSpec.getMode(arg6) != 0x40000000) {
            v0 = arg6;
            v1 = 0;
        }
        else {
            v0 = View$MeasureSpec.makeMeasureSpec(v0, 0x80000000);
            v1 = 1;
        }

        super.onMeasure(v0, arg7);
        if((this.mAllowStacking) && !this.isStacked() && (this.getMeasuredWidthAndState() & 0xFF000000) == 0x1000000) {
            this.setStacked(true);
            v1 = 1;
        }

        if(v1 != 0) {
            super.onMeasure(arg6, arg7);
        }

        v0 = this.getNextVisibleChildIndex(0);
        if(v0 >= 0) {
            View v1_1 = this.getChildAt(v0);
            ViewGroup$LayoutParams v2_1 = v1_1.getLayoutParams();
            int v4 = this.getPaddingTop() + v1_1.getMeasuredHeight() + ((LinearLayout$LayoutParams)v2_1).topMargin + ((LinearLayout$LayoutParams)v2_1).bottomMargin;
            if(this.isStacked()) {
                v0 = this.getNextVisibleChildIndex(v0 + 1);
                if(v0 >= 0) {
                    v4 += this.getChildAt(v0).getPaddingTop() + (((int)(this.getResources().getDisplayMetrics().density * 16f)));
                }

                v2 = v4;
            }
            else {
                v2 = v4 + this.getPaddingBottom();
            }
        }

        if(ViewCompat.getMinimumHeight(((View)this)) != v2) {
            this.setMinimumHeight(v2);
            if(arg7 == 0) {
                super.onMeasure(arg6, arg7);
            }
        }
    }

    public void setAllowStacking(boolean arg2) {
        if(this.mAllowStacking != arg2) {
            this.mAllowStacking = arg2;
            if(!arg2 && (this.isStacked())) {
                this.setStacked(false);
            }

            this.requestLayout();
        }
    }

    private void setStacked(boolean arg2) {
        int v2;
        if(this.mStacked != arg2 && (!arg2 || (this.mAllowStacking))) {
            this.mStacked = arg2;
            this.setOrientation(((int)arg2));
            int v0 = arg2 ? 0x800005 : 80;
            this.setGravity(v0);
            View v0_1 = this.findViewById(id.spacer);
            if(v0_1 != null) {
                v2 = arg2 ? 8 : 4;
                v0_1.setVisibility(v2);
            }

            for(v2 = this.getChildCount() - 2; v2 >= 0; --v2) {
                this.bringChildToFront(this.getChildAt(v2));
            }
        }
    }
}

