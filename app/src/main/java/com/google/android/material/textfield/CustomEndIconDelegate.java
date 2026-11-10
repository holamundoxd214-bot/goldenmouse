package com.google.android.material.textfield;

class CustomEndIconDelegate extends EndIconDelegate {
    CustomEndIconDelegate(EndCompoundLayout arg1) {
        super(arg1);
    }

    void setUp() {
        this.endLayout.setEndIconOnLongClickListener(null);
    }
}

