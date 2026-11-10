package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;

public class InsetDialogOnTouchListener implements View$OnTouchListener {
    private final Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(Dialog arg2, Rect arg3) {
        super();
        this.dialog = arg2;
        this.leftInset = arg3.left;
        this.topInset = arg3.top;
        this.prePieSlop = ViewConfiguration.get(arg2.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View arg6, MotionEvent arg7) {
        View v0 = arg6.findViewById(0x1020002);
        int v1 = this.leftInset + v0.getLeft();
        int v2 = v0.getWidth() + v1;
        int v3 = this.topInset + v0.getTop();
        if(new RectF(((float)v1), ((float)v3), ((float)v2), ((float)(v0.getHeight() + v3))).contains(arg7.getX(), arg7.getY())) {
            return 0;
        }

        MotionEvent v0_1 = MotionEvent.obtain(arg7);
        if(arg7.getAction() == 1) {
            v0_1.setAction(4);
        }

        if(Build$VERSION.SDK_INT < 28) {
            v0_1.setAction(0);
            v0_1.setLocation(((float)(-this.prePieSlop - 1)), ((float)(-this.prePieSlop - 1)));
        }

        arg6.performClick();
        return this.dialog.onTouchEvent(v0_1);
    }
}

