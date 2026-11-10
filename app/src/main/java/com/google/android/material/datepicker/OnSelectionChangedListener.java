package com.google.android.material.datepicker;

public abstract class OnSelectionChangedListener {
    public OnSelectionChangedListener() {
        super();
    }

    public void onIncompleteSelectionChanged() {
    }

    public abstract void onSelectionChanged(Object arg1);
}

