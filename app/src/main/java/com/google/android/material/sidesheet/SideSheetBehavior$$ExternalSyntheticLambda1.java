package com.google.android.material.sidesheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final class SideSheetBehavior$$ExternalSyntheticLambda1 implements AccessibilityViewCommand {
    public SideSheetBehavior$$ExternalSyntheticLambda1(SideSheetBehavior arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final boolean perform(View arg2, CommandArguments arg3) {
        return this.f$0.lambda$createAccessibilityViewCommandForState$2$com-google-android-material-sidesheet-SideSheetBehavior(this.f$1, arg2, arg3);
    }
}

