package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View$MeasureSpec;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

public class ContentFrameLayout extends FrameLayout {
    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public ContentFrameLayout(Context arg2) {
        this(arg2, null);
    }

    public ContentFrameLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ContentFrameLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mDecorPadding = new Rect();
    }

    public void dispatchFitSystemWindows(Rect arg1) {
        this.fitSystemWindows(arg1);
    }

    public TypedValue getFixedHeightMajor() {
        TypedValue v0 = this.mFixedHeightMajor;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mFixedHeightMajor = v0;
        }

        return v0;
    }

    public TypedValue getFixedHeightMinor() {
        TypedValue v0 = this.mFixedHeightMinor;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mFixedHeightMinor = v0;
        }

        return v0;
    }

    public TypedValue getFixedWidthMajor() {
        TypedValue v0 = this.mFixedWidthMajor;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mFixedWidthMajor = v0;
        }

        return v0;
    }

    public TypedValue getFixedWidthMinor() {
        TypedValue v0 = this.mFixedWidthMinor;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mFixedWidthMinor = v0;
        }

        return v0;
    }

    public TypedValue getMinWidthMajor() {
        TypedValue v0 = this.mMinWidthMajor;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mMinWidthMajor = v0;
        }

        return v0;
    }

    public TypedValue getMinWidthMinor() {
        TypedValue v0 = this.mMinWidthMinor;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mMinWidthMinor = v0;
        }

        return v0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener v0 = this.mAttachListener;
        if(v0 != null) {
            v0.onAttachedFromWindow();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener v0 = this.mAttachListener;
        if(v0 != null) {
            v0.onDetachedFromWindow();
        }
    }

    protected void onMeasure(int arg14, int arg15) {
        int v0_2;
        float v0_1;
        float v5_2;
        int v10_2;
        float v10_1;
        DisplayMetrics v0 = this.getContext().getResources().getDisplayMetrics();
        int v3 = 1;
        int v1 = v0.widthPixels < v0.heightPixels ? 1 : 0;
        int v2 = View$MeasureSpec.getMode(arg14);
        int v5 = View$MeasureSpec.getMode(arg15);
        int v6 = 6;
        int v7 = 5;
        int v8 = 0x80000000;
        int v9 = 0x40000000;
        if(v2 == v8) {
            TypedValue v10 = v1 != 0 ? this.mFixedWidthMinor : this.mFixedWidthMajor;
            if(v10 == null) {
                goto label_51;
            }

            if(v10.type == 0) {
                goto label_51;
            }

            if(v10.type == v7) {
                v10_1 = v10.getDimension(v0);
                goto label_28;
            }
            else if(v10.type == v6) {
                v10_1 = v10.getFraction(((float)v0.widthPixels), ((float)v0.widthPixels));
            label_28:
                v10_2 = ((int)v10_1);
            }
            else {
                v10_2 = 0;
            }

            if(v10_2 <= 0) {
                goto label_51;
            }

            arg14 = View$MeasureSpec.makeMeasureSpec(Math.min(v10_2 - (this.mDecorPadding.left + this.mDecorPadding.right), View$MeasureSpec.getSize(arg14)), v9);
            v10_2 = 1;
        }
        else {
        label_51:
            v10_2 = 0;
        }

        if(v5 == v8) {
            TypedValue v5_1 = v1 != 0 ? this.mFixedHeightMajor : this.mFixedHeightMinor;
            if(v5_1 == null) {
                goto label_84;
            }

            if(v5_1.type == 0) {
                goto label_84;
            }

            if(v5_1.type == v7) {
                v5_2 = v5_1.getDimension(v0);
                goto label_63;
            }
            else if(v5_1.type == v6) {
                v5_2 = v5_1.getFraction(((float)v0.heightPixels), ((float)v0.heightPixels));
            label_63:
                v5 = ((int)v5_2);
            }
            else {
                v5 = 0;
            }

            if(v5 <= 0) {
                goto label_84;
            }

            arg15 = View$MeasureSpec.makeMeasureSpec(Math.min(v5 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View$MeasureSpec.getSize(arg15)), v9);
        }

    label_84:
        super.onMeasure(arg14, arg15);
        arg14 = this.getMeasuredWidth();
        v5 = View$MeasureSpec.makeMeasureSpec(arg14, v9);
        if(v10_2 != 0 || v2 != v8) {
        label_120:
            v3 = 0;
        }
        else {
            TypedValue v1_1 = v1 != 0 ? this.mMinWidthMinor : this.mMinWidthMajor;
            if(v1_1 == null) {
                goto label_120;
            }

            if(v1_1.type == 0) {
                goto label_120;
            }

            if(v1_1.type == v7) {
                v0_1 = v1_1.getDimension(v0);
                goto label_99;
            }
            else if(v1_1.type == v6) {
                v0_1 = v1_1.getFraction(((float)v0.widthPixels), ((float)v0.widthPixels));
            label_99:
                v0_2 = ((int)v0_1);
            }
            else {
                v0_2 = 0;
            }

            if(v0_2 > 0) {
                v0_2 -= this.mDecorPadding.left + this.mDecorPadding.right;
            }

            if(arg14 >= v0_2) {
                goto label_120;
            }

            v5 = View$MeasureSpec.makeMeasureSpec(v0_2, v9);
        }

        if(v3 != 0) {
            super.onMeasure(v5, arg15);
        }
    }

    public void setAttachListener(OnAttachListener arg1) {
        this.mAttachListener = arg1;
    }

    public void setDecorPadding(int arg2, int arg3, int arg4, int arg5) {
        this.mDecorPadding.set(arg2, arg3, arg4, arg5);
        if(ViewCompat.isLaidOut(((View)this))) {
            this.requestLayout();
        }
    }
}

