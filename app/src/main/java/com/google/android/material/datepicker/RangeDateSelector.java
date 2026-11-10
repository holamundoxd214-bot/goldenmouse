package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
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

public class RangeDateSelector implements DateSelector {
    class com.google.android.material.datepicker.RangeDateSelector$3 implements Parcelable$Creator {
        com.google.android.material.datepicker.RangeDateSelector$3() {
            super();
        }

        public RangeDateSelector createFromParcel(Parcel arg3) {
            RangeDateSelector v2 = new RangeDateSelector();
            Class v0 = Long.class;
            v2.selectedStartItem = arg3.readValue(v0.getClassLoader());
            v2.selectedEndItem = arg3.readValue(v0.getClassLoader());
            return v2;
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public RangeDateSelector[] newArray(int arg1) {
            return new RangeDateSelector[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    private CharSequence error;
    private final String invalidRangeEndError;
    private String invalidRangeStartError;
    private Long proposedTextEnd;
    private Long proposedTextStart;
    private Long selectedEndItem;
    private Long selectedStartItem;
    private SimpleDateFormat textInputFormat;

    static {
        RangeDateSelector.CREATOR = new com.google.android.material.datepicker.RangeDateSelector$3();
    }

    public RangeDateSelector() {
        super();
        this.invalidRangeEndError = " ";
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    static Long access$002(RangeDateSelector arg0, Long arg1) {
        arg0.proposedTextStart = arg1;
        return arg1;
    }

    static void access$100(RangeDateSelector arg0, TextInputLayout arg1, TextInputLayout arg2, OnSelectionChangedListener arg3) {
        arg0.updateIfValidTextProposal(arg1, arg2, arg3);
    }

    static Long access$202(RangeDateSelector arg0, Long arg1) {
        arg0.proposedTextEnd = arg1;
        return arg1;
    }

    static Long access$302(RangeDateSelector arg0, Long arg1) {
        arg0.selectedStartItem = arg1;
        return arg1;
    }

    static Long access$402(RangeDateSelector arg0, Long arg1) {
        arg0.selectedEndItem = arg1;
        return arg1;
    }

    private void clearInvalidRange(TextInputLayout arg3, TextInputLayout arg4) {
        CharSequence v1 = null;
        if(arg3.getError() != null && (this.invalidRangeStartError.contentEquals(arg3.getError()))) {
            arg3.setError(v1);
        }

        if(arg4.getError() != null && (" ".contentEquals(arg4.getError()))) {
            arg4.setError(v1);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context arg3) {
        Resources v2 = arg3.getResources();
        DisplayMetrics v0 = v2.getDisplayMetrics();
        int v2_1 = Math.min(v0.widthPixels, v0.heightPixels) > v2.getDimensionPixelSize(dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? attr.materialCalendarTheme : attr.materialCalendarFullscreenTheme;
        return MaterialAttributes.resolveOrThrow(arg3, v2_1, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return string.mtrl_picker_range_header_title;
    }

    public String getError() {
        if(TextUtils.isEmpty(this.error)) {
            return null;
        }

        return this.error.toString();
    }

    public Collection getSelectedDays() {
        ArrayList v0 = new ArrayList();
        Long v1 = this.selectedStartItem;
        if(v1 != null) {
            v0.add(v1);
        }

        Long v2 = this.selectedEndItem;
        if(v2 != null) {
            v0.add(v2);
        }

        return ((Collection)v0);
    }

    public Collection getSelectedRanges() {
        ArrayList v0 = new ArrayList();
        v0.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return ((Collection)v0);
    }

    public Pair getSelection() {
        return new Pair(this.selectedStartItem, this.selectedEndItem);
    }

    public Object getSelection() {
        return this.getSelection();
    }

    public String getSelectionContentDescription(Context arg3) {
        String v2_1;
        Object v0_1;
        Resources v3 = arg3.getResources();
        Pair v2 = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        if(v2.first == null) {
            String v0 = v3.getString(string.mtrl_picker_announce_current_selection_none);
        }
        else {
            v0_1 = v2.first;
        }

        if(v2.second == null) {
            v2_1 = v3.getString(string.mtrl_picker_announce_current_selection_none);
        }
        else {
            Object v2_2 = v2.second;
        }

        return v3.getString(string.mtrl_picker_announce_current_range_selection, new Object[]{v0_1, v2_1});
    }

    public String getSelectionDisplayString(Context arg4) {
        Resources v4 = arg4.getResources();
        Long v0 = this.selectedStartItem;
        if(v0 == null && this.selectedEndItem == null) {
            return v4.getString(string.mtrl_picker_range_header_unselected);
        }

        Long v1 = this.selectedEndItem;
        if(v1 == null) {
            return v4.getString(string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(this.selectedStartItem.longValue())});
        }

        if(v0 == null) {
            return v4.getString(string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(this.selectedEndItem.longValue())});
        }

        Pair v3 = DateStrings.getDateRangeString(v0, v1);
        return v4.getString(string.mtrl_picker_range_header_selected, new Object[]{v3.first, v3.second});
    }

    public boolean isSelectionComplete() {
        Long v0 = this.selectedStartItem;
        if(v0 != null && this.selectedEndItem != null && (this.isValidRange(v0.longValue(), this.selectedEndItem.longValue()))) {
            return 1;
        }

        return 0;
    }

    private boolean isValidRange(long arg1, long arg3) {
        if(arg1 <= arg3) {
            return 1;
        }

        return 0;
    }

    public View onCreateTextInputView(LayoutInflater arg14, ViewGroup arg15, Bundle arg16, CalendarConstraints arg17, OnSelectionChangedListener arg18) {
        View v14 = arg14.inflate(layout.mtrl_picker_text_input_date_range, arg15, false);
        View v6 = v14.findViewById(id.mtrl_picker_text_input_range_start);
        View v9 = v14.findViewById(id.mtrl_picker_text_input_range_end);
        EditText v0 = ((TextInputLayout)v6).getEditText();
        EditText v11 = ((TextInputLayout)v9).getEditText();
        if(ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            v0.setInputType(17);
            v11.setInputType(17);
        }

        this.invalidRangeStartError = v14.getResources().getString(string.mtrl_picker_invalid_range);
        SimpleDateFormat v2 = this.textInputFormat;
        int v3 = v2 != null ? 1 : 0;
        if(v3 != 0) {
        }
        else {
            v2 = UtcDates.getDefaultTextInputFormat();
        }

        SimpleDateFormat v5 = v2;
        Long v2_1 = this.selectedStartItem;
        if(v2_1 != null) {
            v0.setText(v5.format(v2_1));
            this.proposedTextStart = this.selectedStartItem;
        }

        v2_1 = this.selectedEndItem;
        if(v2_1 != null) {
            v11.setText(v5.format(v2_1));
            this.proposedTextEnd = this.selectedEndItem;
        }

        String v2_2 = v3 != 0 ? v5.toPattern() : UtcDates.getDefaultTextInputHint(v14.getResources(), v5);
        ((TextInputLayout)v6).setPlaceholderText(v2_2);
        ((TextInputLayout)v9).setPlaceholderText(v2_2);
        v0.addTextChangedListener(new DateFormatTextWatcher(v2_2, ((DateFormat)v5), ((TextInputLayout)v6), arg17, v6, ((TextInputLayout)v9), arg18) {
            void onInvalidDate() {
                RangeDateSelector.this.proposedTextStart = null;
                RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
            }

            void onValidDate(Long arg3) {
                RangeDateSelector.this.proposedTextStart = arg3;
                RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
            }
        });
        v11.addTextChangedListener(new DateFormatTextWatcher(v2_2, ((DateFormat)v5), v9, arg17, v6, ((TextInputLayout)v9), arg18) {
            void onInvalidDate() {
                RangeDateSelector.this.proposedTextEnd = null;
                RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
            }

            void onValidDate(Long arg3) {
                RangeDateSelector.this.proposedTextEnd = arg3;
                RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
            }
        });
        DateSelector.showKeyboardWithAutoHideBehavior(new EditText[]{v0, v11});
        return v14;
    }

    public void select(long arg3) {
        Long v0 = this.selectedStartItem;
        if(v0 == null) {
            this.selectedStartItem = Long.valueOf(arg3);
            return;
        }

        if(this.selectedEndItem == null && (this.isValidRange(v0.longValue(), arg3))) {
            this.selectedEndItem = Long.valueOf(arg3);
            return;
        }

        this.selectedEndItem = null;
        this.selectedStartItem = Long.valueOf(arg3);
    }

    private void setInvalidRange(TextInputLayout arg1, TextInputLayout arg2) {
        arg1.setError(this.invalidRangeStartError);
        arg2.setError(" ");
    }

    public void setSelection(Pair arg5) {
        if(arg5.first != null && arg5.second != null) {
            Preconditions.checkArgument(this.isValidRange(arg5.first.longValue(), arg5.second.longValue()));
        }

        Long v1 = null;
        Long v0 = arg5.first == null ? v1 : Long.valueOf(UtcDates.canonicalYearMonthDay(arg5.first.longValue()));
        this.selectedStartItem = v0;
        if(arg5.second == null) {
        }
        else {
            v1 = Long.valueOf(UtcDates.canonicalYearMonthDay(arg5.second.longValue()));
        }

        this.selectedEndItem = v1;
    }

    public void setSelection(Object arg1) {
        this.setSelection(((Pair)arg1));
    }

    public void setTextInputFormat(SimpleDateFormat arg1) {
        DateFormat v1;
        if(arg1 != null) {
            v1 = UtcDates.getNormalizedFormat(((DateFormat)arg1));
        }

        this.textInputFormat = ((SimpleDateFormat)v1);
    }

    private void updateError(TextInputLayout arg2, TextInputLayout arg3) {
        if(!TextUtils.isEmpty(arg2.getError())) {
            this.error = arg2.getError();
            return;
        }

        if(!TextUtils.isEmpty(arg3.getError())) {
            this.error = arg3.getError();
            return;
        }

        this.error = null;
    }

    private void updateIfValidTextProposal(TextInputLayout arg5, TextInputLayout arg6, OnSelectionChangedListener arg7) {
        Long v0 = this.proposedTextStart;
        if(v0 == null || this.proposedTextEnd == null) {
            this.clearInvalidRange(arg5, arg6);
            arg7.onIncompleteSelectionChanged();
        }
        else if(this.isValidRange(v0.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            arg7.onSelectionChanged(this.getSelection());
        }
        else {
            this.setInvalidRange(arg5, arg6);
            arg7.onIncompleteSelectionChanged();
        }

        this.updateError(arg5, arg6);
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeValue(this.selectedStartItem);
        arg1.writeValue(this.selectedEndItem);
    }
}

