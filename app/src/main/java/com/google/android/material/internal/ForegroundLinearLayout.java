package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final Rect overlayBounds;
    private final Rect selfBounds;

    public ForegroundLinearLayout(Context arg2) {
        this(arg2, null);
    }

    public ForegroundLinearLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ForegroundLinearLayout(Context arg9, AttributeSet arg10, int arg11) {
        super(arg9, arg10, arg11);
        this.selfBounds = new Rect();
        this.overlayBounds = new Rect();
        this.foregroundGravity = 0x77;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        TypedArray v9 = ThemeEnforcement.obtainStyledAttributes(arg9, arg10, styleable.ForegroundLinearLayout, arg11, 0, new int[0]);
        this.foregroundGravity = v9.getInt(styleable.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
        Drawable v10 = v9.getDrawable(styleable.ForegroundLinearLayout_android_foreground);
        if(v10 != null) {
            this.setForeground(v10);
        }

        this.mForegroundInPadding = v9.getBoolean(styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        v9.recycle();
    }

    public void draw(Canvas arg9) {
        super.draw(arg9);
        Drawable v0 = this.foreground;
        if(v0 != null) {
            if(this.foregroundBoundsChanged) {
                this.foregroundBoundsChanged = false;
                Rect v2 = this.selfBounds;
                Rect v3 = this.overlayBounds;
                int v4 = this.getRight() - this.getLeft();
                int v5 = this.getBottom() - this.getTop();
                if(this.mForegroundInPadding) {
                    v2.set(0, 0, v4, v5);
                }
                else {
                    v2.set(this.getPaddingLeft(), this.getPaddingTop(), v4 - this.getPaddingRight(), v5 - this.getPaddingBottom());
                }

                Gravity.apply(this.foregroundGravity, v0.getIntrinsicWidth(), v0.getIntrinsicHeight(), v2, v3);
                v0.setBounds(v3);
            }

            v0.draw(arg9);
        }
    }

    public void drawableHotspotChanged(float arg1, float arg2) {
        super.drawableHotspotChanged(arg1, arg2);
        Drawable v0 = this.foreground;
        if(v0 != null) {
            v0.setHotspot(arg1, arg2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable v0 = this.foreground;
        if(v0 != null && (v0.isStateful())) {
            this.foreground.setState(this.getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.foreground;
    }

    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable v0 = this.foreground;
        if(v0 != null) {
            v0.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        this.foregroundBoundsChanged |= ((int)arg1);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.foregroundBoundsChanged = true;
    }

    public void setForeground(Drawable arg3) {
        Drawable v0 = this.foreground;
        if(v0 != arg3) {
            if(v0 != null) {
                v0.setCallback(null);
                this.unscheduleDrawable(this.foreground);
            }

            this.foreground = arg3;
            this.foregroundBoundsChanged = true;
            if(arg3 != null) {
                this.setWillNotDraw(false);
                arg3.setCallback(((Drawable$Callback)this));
                if(arg3.isStateful()) {
                    arg3.setState(this.getDrawableState());
                }

                if(this.foregroundGravity != 0x77) {
                    goto label_26;
                }

                arg3.getPadding(new Rect());
            }
            else {
                this.setWillNotDraw(true);
            }

        label_26:
            this.requestLayout();
            this.invalidate();
        }
    }

    public void setForegroundGravity(int arg2) {
        if(this.foregroundGravity != arg2) {
            if((0x800007 & arg2) == 0) {
                arg2 |= 0x800003;
            }

            if((arg2 & 0x70) == 0) {
                arg2 |= 0x30;
            }

            this.foregroundGravity = arg2;
            if(arg2 == 0x77 && this.foreground != null) {
                this.foreground.getPadding(new Rect());
            }

            this.requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(!super.verifyDrawable(arg2)) {
            if(arg2 == this.foreground) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

