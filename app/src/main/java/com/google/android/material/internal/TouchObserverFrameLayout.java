package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.FrameLayout;

public class TouchObserverFrameLayout extends FrameLayout {
    private View$OnTouchListener onTouchListener;

    public TouchObserverFrameLayout(Context arg1) {
        super(arg1);
    }

    public TouchObserverFrameLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public TouchObserverFrameLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
    }

    public boolean onInterceptTouchEvent(MotionEvent arg2) {
        View$OnTouchListener v0 = this.onTouchListener;
        if(v0 != null) {
            v0.onTouch(((View)this), arg2);
        }

        return super.onInterceptTouchEvent(arg2);
    }

    public void setOnTouchListener(View$OnTouchListener arg1) {
        this.onTouchListener = arg1;
    }
}

