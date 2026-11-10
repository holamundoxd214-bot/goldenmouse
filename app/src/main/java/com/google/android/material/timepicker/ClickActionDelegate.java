package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class ClickActionDelegate extends AccessibilityDelegateCompat {
    private final AccessibilityActionCompat clickAction;

    public ClickActionDelegate(Context arg3, int arg4) {
        super();
        this.clickAction = new AccessibilityActionCompat(16, arg3.getString(arg4));
    }

    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        super.onInitializeAccessibilityNodeInfo(arg1, arg2);
        arg2.addAction(this.clickAction);
    }
}

