package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import java.lang.reflect.Field;
import java.util.Locale;

class TimePickerTextInputPresenter implements TimePickerPresenter, OnSelectionChange {
    class com.google.android.material.timepicker.TimePickerTextInputPresenter$1 extends TextWatcherAdapter {
        com.google.android.material.timepicker.TimePickerTextInputPresenter$1(TimePickerTextInputPresenter arg1) {
            TimePickerTextInputPresenter.this = arg1;
            super();
        }

        public void afterTextChanged(Editable arg2) {
            try {
                if(TextUtils.isEmpty(((CharSequence)arg2))) {
                    TimePickerTextInputPresenter.this.time.setMinute(0);
                    return;
                }

                TimePickerTextInputPresenter.this.time.setMinute(Integer.parseInt(arg2.toString()));
                return;
            }
            catch(NumberFormatException ) {
                return;
            }
        }
    }

    class com.google.android.material.timepicker.TimePickerTextInputPresenter$2 extends TextWatcherAdapter {
        com.google.android.material.timepicker.TimePickerTextInputPresenter$2(TimePickerTextInputPresenter arg1) {
            TimePickerTextInputPresenter.this = arg1;
            super();
        }

        public void afterTextChanged(Editable arg2) {
            try {
                if(TextUtils.isEmpty(((CharSequence)arg2))) {
                    TimePickerTextInputPresenter.this.time.setHour(0);
                    return;
                }

                TimePickerTextInputPresenter.this.time.setHour(Integer.parseInt(arg2.toString()));
                return;
            }
            catch(NumberFormatException ) {
                return;
            }
        }
    }

    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final TextWatcher hourTextWatcher;
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TextWatcher minuteTextWatcher;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout arg7, TimeModel arg8) {
        super();
        this.minuteTextWatcher = new com.google.android.material.timepicker.TimePickerTextInputPresenter$1(this);
        this.hourTextWatcher = new com.google.android.material.timepicker.TimePickerTextInputPresenter$2(this);
        this.timePickerView = arg7;
        this.time = arg8;
        Resources v0 = arg7.getResources();
        View v1 = arg7.findViewById(id.material_minute_text_input);
        this.minuteTextInput = ((ChipTextInputComboView)v1);
        View v2 = arg7.findViewById(id.material_hour_text_input);
        this.hourTextInput = ((ChipTextInputComboView)v2);
        View v3 = ((ChipTextInputComboView)v1).findViewById(id.material_label);
        View v4 = ((ChipTextInputComboView)v2).findViewById(id.material_label);
        ((TextView)v3).setText(v0.getString(string.material_timepicker_minute));
        ((TextView)v4).setText(v0.getString(string.material_timepicker_hour));
        ((ChipTextInputComboView)v1).setTag(id.selection_type, Integer.valueOf(12));
        ((ChipTextInputComboView)v2).setTag(id.selection_type, Integer.valueOf(10));
        if(arg8.format == 0) {
            this.setupPeriodToggle();
        }

        com.google.android.material.timepicker.TimePickerTextInputPresenter$3 v0_1 = new View$OnClickListener() {
            public void onClick(View arg2) {
                TimePickerTextInputPresenter.this.onSelectionChanged(arg2.getTag(id.selection_type).intValue());
            }
        };
        ((ChipTextInputComboView)v2).setOnClickListener(((View$OnClickListener)v0_1));
        ((ChipTextInputComboView)v1).setOnClickListener(((View$OnClickListener)v0_1));
        ((ChipTextInputComboView)v2).addInputFilter(arg8.getHourInputValidator());
        ((ChipTextInputComboView)v1).addInputFilter(arg8.getMinuteInputValidator());
        this.hourEditText = ((ChipTextInputComboView)v2).getTextInput().getEditText();
        this.minuteEditText = ((ChipTextInputComboView)v1).getTextInput().getEditText();
        this.controller = new TimePickerTextInputKeyController(((ChipTextInputComboView)v2), ((ChipTextInputComboView)v1), arg8);
        ((ChipTextInputComboView)v2).setChipDelegate(new ClickActionDelegate(arg7.getContext(), string.material_hour_selection, arg8) {
            public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
                super.onInitializeAccessibilityNodeInfo(arg2, arg3);
                arg3.setContentDescription(arg2.getResources().getString(this.val$time.getHourContentDescriptionResId(), new Object[]{String.valueOf(this.val$time.getHourForDisplay())}));
            }
        });
        ((ChipTextInputComboView)v1).setChipDelegate(new ClickActionDelegate(arg7.getContext(), string.material_minute_selection, arg8) {
            public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
                super.onInitializeAccessibilityNodeInfo(arg2, arg3);
                arg3.setContentDescription(arg2.getResources().getString(string.material_minute_suffix, new Object[]{String.valueOf(this.val$time.minute)}));
            }
        });
        this.initialize();
    }

    static TimeModel access$000(TimePickerTextInputPresenter arg0) {
        return arg0.time;
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    public void hide() {
        View v0 = this.timePickerView.getFocusedChild();
        if(v0 != null) {
            ViewUtils.hideKeyboard(v0, false);
        }

        this.timePickerView.setVisibility(8);
    }

    public void initialize() {
        this.addTextWatchers();
        this.setTime(this.time);
        this.controller.bind();
    }

    public void invalidate() {
        this.setTime(this.time);
    }

    void lambda$setupPeriodToggle$0$com-google-android-material-timepicker-TimePickerTextInputPresenter(MaterialButtonToggleGroup arg1, int arg2, boolean arg3) {
        if(!arg3) {
            return;
        }

        int v1 = arg2 == id.material_clock_period_pm_button ? 1 : 0;
        this.time.setPeriod(v1);
    }

    public void onSelectionChanged(int arg5) {
        this.time.selection = arg5;
        ChipTextInputComboView v0 = this.minuteTextInput;
        boolean v2 = true;
        boolean v1 = arg5 == 12 ? true : false;
        v0.setChecked(v1);
        v0 = this.hourTextInput;
        if(arg5 == 10) {
        }
        else {
            v2 = false;
        }

        v0.setChecked(v2);
        this.updateSelection();
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    public void resetChecked() {
        ChipTextInputComboView v0 = this.minuteTextInput;
        boolean v3 = true;
        boolean v1 = this.time.selection == 12 ? true : false;
        v0.setChecked(v1);
        v0 = this.hourTextInput;
        if(this.time.selection == 10) {
        }
        else {
            v3 = false;
        }

        v0.setChecked(v3);
    }

    private static void setCursorDrawableColor(EditText arg5, int arg6) {
        try {
            Context v0 = arg5.getContext();
            Class v1 = TextView.class;
            Field v2 = v1.getDeclaredField("mCursorDrawableRes");
            v2.setAccessible(true);
            int v2_1 = v2.getInt(arg5);
            Field v1_1 = v1.getDeclaredField("mEditor");
            v1_1.setAccessible(true);
            Object v5 = v1_1.get(arg5);
            v1_1 = v5.getClass().getDeclaredField("mCursorDrawable");
            v1_1.setAccessible(true);
            Drawable v0_1 = AppCompatResources.getDrawable(v0, v2_1);
            v0_1.setColorFilter(arg6, PorterDuff$Mode.SRC_IN);
            v1_1.set(v5, new Drawable[]{v0_1, v0_1});
            return;
        }
        catch(Throwable ) {
            return;
        }
    }

    private void setTime(TimeModel arg4) {
        this.removeTextWatchers();
        Locale v0 = this.timePickerView.getResources().getConfiguration().locale;
        String v1 = String.format(v0, "%02d", Integer.valueOf(arg4.minute));
        String v4 = String.format(v0, "%02d", Integer.valueOf(arg4.getHourForDisplay()));
        this.minuteTextInput.setText(((CharSequence)v1));
        this.hourTextInput.setText(((CharSequence)v4));
        this.addTextWatchers();
        this.updateSelection();
    }

    private void setupPeriodToggle() {
        View v0 = this.timePickerView.findViewById(id.material_clock_period_toggle);
        this.toggle = ((MaterialButtonToggleGroup)v0);
        ((MaterialButtonToggleGroup)v0).addOnButtonCheckedListener(new TimePickerTextInputPresenter$$ExternalSyntheticLambda0(this));
        this.toggle.setVisibility(0);
        this.updateSelection();
    }

    public void show() {
        this.timePickerView.setVisibility(0);
        this.onSelectionChanged(this.time.selection);
    }

    private void updateSelection() {
        MaterialButtonToggleGroup v0 = this.toggle;
        if(v0 == null) {
            return;
        }

        int v1 = this.time.period == 0 ? id.material_clock_period_am_button : id.material_clock_period_pm_button;
        v0.check(v1);
    }
}

