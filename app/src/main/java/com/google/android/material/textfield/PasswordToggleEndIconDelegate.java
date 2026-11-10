package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;

class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private EditText editText;
    private int iconResId;
    private final View$OnClickListener onIconClickListener;

    PasswordToggleEndIconDelegate(EndCompoundLayout arg1, int arg2) {
        super(arg1);
        this.iconResId = drawable.design_password_eye;
        this.onIconClickListener = new PasswordToggleEndIconDelegate$$ExternalSyntheticLambda0(this);
        if(arg2 != 0) {
            this.iconResId = arg2;
        }
    }

    void beforeEditTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
        this.refreshIconState();
    }

    int getIconContentDescriptionResId() {
        return string.password_toggle_content_description;
    }

    int getIconDrawableResId() {
        return this.iconResId;
    }

    View$OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    private boolean hasPasswordTransformation() {
        EditText v0 = this.editText;
        if(v0 != null && ((v0.getTransformationMethod() instanceof PasswordTransformationMethod))) {
            return 1;
        }

        return 0;
    }

    boolean isIconCheckable() {
        return 1;
    }

    boolean isIconChecked() {
        return this.hasPasswordTransformation() ^ 1;
    }

    private static boolean isInputTypePassword(EditText arg2) {
        if(arg2 != null && (arg2.getInputType() == 16 || arg2.getInputType() == 0x80 || arg2.getInputType() == 0x90 || arg2.getInputType() == 0xE0)) {
            return 1;
        }

        return 0;
    }

    void lambda$new$0$com-google-android-material-textfield-PasswordToggleEndIconDelegate(View arg3) {
        EditText v3 = this.editText;
        if(v3 == null) {
            return;
        }

        int v3_1 = v3.getSelectionEnd();
        boolean v0 = this.hasPasswordTransformation();
        EditText v1 = this.editText;
        if(v0) {
            v1.setTransformationMethod(null);
        }
        else {
            v1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        if(v3_1 >= 0) {
            this.editText.setSelection(v3_1);
        }

        this.refreshIconState();
    }

    void onEditTextAttached(EditText arg1) {
        this.editText = arg1;
        this.refreshIconState();
    }

    void setUp() {
        if(PasswordToggleEndIconDelegate.isInputTypePassword(this.editText)) {
            this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    void tearDown() {
        EditText v1 = this.editText;
        if(v1 != null) {
            v1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}

