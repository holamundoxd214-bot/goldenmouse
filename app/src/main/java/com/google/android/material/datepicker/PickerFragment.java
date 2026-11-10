package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class PickerFragment extends Fragment {
    protected final LinkedHashSet onSelectionChangedListeners;

    PickerFragment() {
        super();
        this.onSelectionChangedListeners = new LinkedHashSet();
    }

    boolean addOnSelectionChangedListener(OnSelectionChangedListener arg1) {
        return this.onSelectionChangedListeners.add(arg1);
    }

    void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    abstract DateSelector getDateSelector();

    boolean removeOnSelectionChangedListener(OnSelectionChangedListener arg1) {
        return this.onSelectionChangedListeners.remove(arg1);
    }
}

