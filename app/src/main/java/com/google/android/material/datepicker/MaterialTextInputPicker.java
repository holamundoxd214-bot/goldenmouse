package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class MaterialTextInputPicker extends PickerFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private CalendarConstraints calendarConstraints;
    private DateSelector dateSelector;
    private int themeResId;

    public MaterialTextInputPicker() {
        super();
    }

    public DateSelector getDateSelector() {
        DateSelector v1 = this.dateSelector;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    static MaterialTextInputPicker newInstance(DateSelector arg3, int arg4, CalendarConstraints arg5) {
        MaterialTextInputPicker v0 = new MaterialTextInputPicker();
        Bundle v1 = new Bundle();
        v1.putInt("THEME_RES_ID_KEY", arg4);
        v1.putParcelable("DATE_SELECTOR_KEY", ((Parcelable)arg3));
        v1.putParcelable("CALENDAR_CONSTRAINTS_KEY", ((Parcelable)arg5));
        v0.setArguments(v1);
        return v0;
    }

    public void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        if(arg2 == null) {
            arg2 = this.getArguments();
        }

        this.themeResId = arg2.getInt("THEME_RES_ID_KEY");
        this.dateSelector = arg2.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = arg2.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    public View onCreateView(LayoutInflater arg10, ViewGroup arg11, Bundle arg12) {
        return this.dateSelector.onCreateTextInputView(arg10.cloneInContext(new ContextThemeWrapper(this.getContext(), this.themeResId)), arg11, arg12, this.calendarConstraints, new OnSelectionChangedListener() {
            public void onIncompleteSelectionChanged() {
                Iterator v1 = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
                while(v1.hasNext()) {
                    v1.next().onIncompleteSelectionChanged();
                }
            }

            public void onSelectionChanged(Object arg2) {
                Iterator v1 = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
                while(v1.hasNext()) {
                    v1.next().onSelectionChanged(arg2);
                }
            }
        });
    }

    public void onSaveInstanceState(Bundle arg3) {
        super.onSaveInstanceState(arg3);
        arg3.putInt("THEME_RES_ID_KEY", this.themeResId);
        arg3.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        arg3.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
    }
}

