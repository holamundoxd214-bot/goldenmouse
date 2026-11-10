package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final class BottomSheetDragHandleView$$ExternalSyntheticLambda0 implements AccessibilityViewCommand {
    public BottomSheetDragHandleView$$ExternalSyntheticLambda0(BottomSheetDragHandleView arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean perform(View arg1, CommandArguments arg2) {
        return this.f$0.lambda$onBottomSheetStateChanged$0$com-google-android-material-bottomsheet-BottomSheetDragHandleView(arg1, arg2);
    }
}

