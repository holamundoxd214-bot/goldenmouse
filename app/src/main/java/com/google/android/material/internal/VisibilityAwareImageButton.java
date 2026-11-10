package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context arg2) {
        this(arg2, null);
    }

    public VisibilityAwareImageButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public VisibilityAwareImageButton(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.userSetVisibility = this.getVisibility();
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int arg1, boolean arg2) {
        super.setVisibility(arg1);
        if(arg2) {
            this.userSetVisibility = arg1;
        }
    }

    public void setVisibility(int arg2) {
        this.internalSetVisibility(arg2, true);
    }
}

