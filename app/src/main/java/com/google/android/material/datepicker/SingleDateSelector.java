package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class SingleDateSelector implements DateSelector {
    class com.google.android.material.datepicker.SingleDateSelector$2 implements Parcelable$Creator {
        com.google.android.material.datepicker.SingleDateSelector$2() {
            super();
        }

        public SingleDateSelector createFromParcel(Parcel arg2) {
            SingleDateSelector v1 = new SingleDateSelector();
            v1.selectedItem = arg2.readValue(Long.class.getClassLoader());
            return v1;
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public SingleDateSelector[] newArray(int arg1) {
            return new SingleDateSelector[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    private CharSequence error;
    private Long selectedItem;
    private SimpleDateFormat textInputFormat;

    static {
        SingleDateSelector.CREATOR = new com.google.android.material.datepicker.SingleDateSelector$2();
    }

    public SingleDateSelector() {
        super();
    }

    static void access$000(SingleDateSelector arg0) {
        arg0.clearSelection();
    }

    static CharSequence access$102(SingleDateSelector arg0, CharSequence arg1) {
        arg0.error = arg1;
        return arg1;
    }

    static Long access$202(SingleDateSelector arg0, Long arg1) {
        arg0.selectedItem = arg1;
        return arg1;
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context arg2) {
        return MaterialAttributes.resolveOrThrow(arg2, attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return string.mtrl_picker_date_header_title;
    }

    public String getError() {
        if(TextUtils.isEmpty(this.error)) {
            return null;
        }

        return this.error.toString();
    }

    public Collection getSelectedDays() {
        ArrayList v0 = new ArrayList();
        Long v1 = this.selectedItem;
        if(v1 != null) {
            v0.add(v1);
        }

        return ((Collection)v0);
    }

    public Collection getSelectedRanges() {
        return new ArrayList();
    }

    public Long getSelection() {
        return this.selectedItem;
    }

    public Object getSelection() {
        return this.getSelection();
    }

    public String getSelectionContentDescription(Context arg3) {
        Resources v3 = arg3.getResources();
        Long v2 = this.selectedItem;
        String v2_1 = v2 == null ? v3.getString(string.mtrl_picker_announce_current_selection_none) : DateStrings.getYearMonthDay(v2.longValue());
        return v3.getString(string.mtrl_picker_announce_current_selection, new Object[]{v2_1});
    }

    public String getSelectionDisplayString(Context arg3) {
        Resources v3 = arg3.getResources();
        Long v2 = this.selectedItem;
        if(v2 == null) {
            return v3.getString(string.mtrl_picker_date_header_unselected);
        }

        return v3.getString(string.mtrl_picker_date_header_selected, new Object[]{DateStrings.getYearMonthDay(v2.longValue())});
    }

    public boolean isSelectionComplete() {
        if(this.selectedItem != null) {
            return 1;
        }

        return 0;
    }

    public View onCreateTextInputView(LayoutInflater arg11, ViewGroup arg12, Bundle arg13, CalendarConstraints arg14, OnSelectionChangedListener arg15) {
        View v11 = arg11.inflate(layout.mtrl_picker_text_input_date, arg12, false);
        View v5 = v11.findViewById(id.mtrl_picker_text_input_date);
        EditText v12 = ((TextInputLayout)v5).getEditText();
        if(ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            v12.setInputType(17);
        }

        SimpleDateFormat v13 = this.textInputFormat;
        int v1 = v13 != null ? 1 : 0;
        if(v1 != 0) {
        }
        else {
            v13 = UtcDates.getDefaultTextInputFormat();
        }

        SimpleDateFormat v4 = v13;
        String v13_1 = v1 != 0 ? v4.toPattern() : UtcDates.getDefaultTextInputHint(v11.getResources(), v4);
        String v3 = v13_1;
        ((TextInputLayout)v5).setPlaceholderText(((CharSequence)v3));
        Long v13_2 = this.selectedItem;
        if(v13_2 != null) {
            v12.setText(v4.format(v13_2));
        }

        v12.addTextChangedListener(new DateFormatTextWatcher(v3, ((DateFormat)v4), ((TextInputLayout)v5), arg14, arg15, v5) {
            void onInvalidDate() {
                SingleDateSelector.this.error = this.val$dateTextInput.getError();
                this.val$listener.onIncompleteSelectionChanged();
            }

            void onValidDate(Long arg4) {
                SingleDateSelector v0 = SingleDateSelector.this;
                if(arg4 == null) {
                    v0.clearSelection();
                }
                else {
                    v0.select(arg4.longValue());
                }

                SingleDateSelector.this.error = null;
                this.val$listener.onSelectionChanged(SingleDateSelector.this.getSelection());
            }
        });
        DateSelector.showKeyboardWithAutoHideBehavior(new EditText[]{v12});
        return v11;
    }

    public void select(long arg1) {
        this.selectedItem = Long.valueOf(arg1);
    }

    public void setSelection(Long arg3) {
        arg3 = arg3 == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(arg3.longValue()));
        this.selectedItem = arg3;
    }

    public void setSelection(Object arg1) {
        this.setSelection(((Long)arg1));
    }

    public void setTextInputFormat(SimpleDateFormat arg1) {
        DateFormat v1;
        if(arg1 != null) {
            v1 = UtcDates.getNormalizedFormat(((DateFormat)arg1));
        }

        this.textInputFormat = ((SimpleDateFormat)v1);
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeValue(this.selectedItem);
    }
}

