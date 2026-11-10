package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View$OnClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {
    final Context context;
    final CheckableImageButton endIconView;
    final EndCompoundLayout endLayout;
    final TextInputLayout textInputLayout;

    EndIconDelegate(EndCompoundLayout arg2) {
        super();
        this.textInputLayout = arg2.textInputLayout;
        this.endLayout = arg2;
        this.context = arg2.getContext();
        this.endIconView = arg2.getEndIconView();
    }

    void afterEditTextChanged(Editable arg1) {
    }

    void beforeEditTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
    }

    int getIconContentDescriptionResId() {
        return 0;
    }

    int getIconDrawableResId() {
        return 0;
    }

    View$OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return null;
    }

    View$OnClickListener getOnIconClickListener() {
        return null;
    }

    View$OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return null;
    }

    TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return null;
    }

    boolean isBoxBackgroundModeSupported(int arg1) {
        return 1;
    }

    boolean isIconActivable() {
        return 0;
    }

    boolean isIconActivated() {
        return 0;
    }

    boolean isIconCheckable() {
        return 0;
    }

    boolean isIconChecked() {
        return 0;
    }

    void onEditTextAttached(EditText arg1) {
    }

    void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
    }

    void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
    }

    void onSuffixVisibilityChanged(boolean arg1) {
    }

    final void refreshIconState() {
        this.endLayout.refreshIconState(false);
    }

    void setUp() {
    }

    boolean shouldTintIconOnError() {
        return 0;
    }

    void tearDown() {
    }
}

