package com.google.android.material.textfield;

import android.widget.EditText;

class EditTextUtils {
    private EditTextUtils() {
        super();
    }

    static boolean isEditable(EditText arg0) {
        if(arg0.getInputType() != 0) {
            return 1;
        }

        return 0;
    }
}

