package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(Context arg2) {
        this(arg2, null);
    }

    public TextInputEditText(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.editTextStyle);
    }

    public TextInputEditText(Context arg9, AttributeSet arg10, int arg11) {
        super(MaterialThemeOverlay.wrap(arg9, arg10, arg11, 0), arg10, arg11);
        this.parentRect = new Rect();
        TypedArray v9 = ThemeEnforcement.obtainStyledAttributes(arg9, arg10, styleable.TextInputEditText, arg11, style.Widget_Design_TextInputEditText, new int[0]);
        this.setTextInputLayoutFocusedRectEnabled(v9.getBoolean(styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        v9.recycle();
    }

    private String getAccessibilityNodeInfoText(TextInputLayout arg4) {
        Editable v3 = this.getText();
        CharSequence v4 = arg4.getHint();
        boolean v0 = TextUtils.isEmpty(((CharSequence)v3));
        String v2 = "";
        String v4_1 = !TextUtils.isEmpty(v4) ? v4.toString() : v2;
        if(!v0) {
            StringBuilder v3_1 = new StringBuilder().append(v3);
            if(!TextUtils.isEmpty(((CharSequence)v4_1))) {
                v2 = ", " + v4_1;
            }

            return v3_1.append(v2).toString();
        }

        if(!TextUtils.isEmpty(((CharSequence)v4_1))) {
            return v4_1;
        }

        return v2;
    }

    public void getFocusedRect(Rect arg3) {
        super.getFocusedRect(arg3);
        TextInputLayout v0 = this.getTextInputLayout();
        if((this.shouldUseTextInputLayoutFocusedRect(v0)) && arg3 != null) {
            v0.getFocusedRect(this.parentRect);
            arg3.bottom = this.parentRect.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect arg3, Point arg4) {
        TextInputLayout v0 = this.getTextInputLayout();
        if(this.shouldUseTextInputLayoutFocusedRect(v0)) {
            boolean v3 = v0.getGlobalVisibleRect(arg3, arg4);
            if((v3) && arg4 != null) {
                arg4.offset(-this.getScrollX(), -this.getScrollY());
            }

            return v3;
        }

        return super.getGlobalVisibleRect(arg3, arg4);
    }

    public CharSequence getHint() {
        TextInputLayout v0 = this.getTextInputLayout();
        if(v0 != null && (v0.isProvidingHint())) {
            return v0.getHint();
        }

        return super.getHint();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout v0 = this.getTextInputLayout();
        if(v0 != null) {
            return v0.getHint();
        }

        return null;
    }

    private TextInputLayout getTextInputLayout() {
        ViewParent v1;
        for(v1 = this.getParent(); (v1 instanceof View); v1 = v1.getParent()) {
            if((v1 instanceof TextInputLayout)) {
                return ((TextInputLayout)v1);
            }
        }

        return null;
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout v0 = this.getTextInputLayout();
        if(v0 != null && (v0.isProvidingHint()) && super.getHint() == null && (ManufacturerUtils.isMeizuDevice())) {
            this.setHint("");
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo arg3) {
        InputConnection v0 = super.onCreateInputConnection(arg3);
        if(v0 != null && arg3.hintText == null) {
            arg3.hintText = this.getHintFromLayout();
        }

        return v0;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
        super.onInitializeAccessibilityNodeInfo(arg1);
        this.getTextInputLayout();
    }

    public boolean requestRectangleOnScreen(Rect arg6) {
        TextInputLayout v0 = this.getTextInputLayout();
        if((this.shouldUseTextInputLayoutFocusedRect(v0)) && arg6 != null) {
            this.parentRect.set(arg6.left, arg6.top, arg6.right, arg6.bottom + (v0.getHeight() - this.getHeight()));
            return super.requestRectangleOnScreen(this.parentRect);
        }

        return super.requestRectangleOnScreen(arg6);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean arg1) {
        this.textInputLayoutFocusedRectEnabled = arg1;
    }

    private boolean shouldUseTextInputLayoutFocusedRect(TextInputLayout arg1) {
        if(arg1 != null && (this.textInputLayoutFocusedRectEnabled)) {
            return 1;
        }

        return 0;
    }
}

