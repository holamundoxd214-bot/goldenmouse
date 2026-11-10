package com.google.android.material.timepicker;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$string;

class TimePickerClockPresenter implements OnActionUpListener, OnRotateListener, TimePickerPresenter, OnPeriodChangeListener, OnSelectionChange {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private static final String[] HOUR_CLOCK_24_VALUES;
    private static final String[] HOUR_CLOCK_VALUES;
    private static final String[] MINUTE_CLOCK_VALUES;
    private boolean broadcasting;
    private float hourRotation;
    private float minuteRotation;
    private final TimeModel time;
    private final TimePickerView timePickerView;

    static {
        TimePickerClockPresenter.HOUR_CLOCK_VALUES = new String[]{"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        TimePickerClockPresenter.HOUR_CLOCK_24_VALUES = new String[]{"00", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        TimePickerClockPresenter.MINUTE_CLOCK_VALUES = new String[]{"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    }

    public TimePickerClockPresenter(TimePickerView arg2, TimeModel arg3) {
        super();
        this.broadcasting = false;
        this.timePickerView = arg2;
        this.time = arg3;
        this.initialize();
    }

    static TimeModel access$000(TimePickerClockPresenter arg0) {
        return arg0.time;
    }

    private String[] getHourClockValues() {
        if(this.time.format == 1) {
            return TimePickerClockPresenter.HOUR_CLOCK_24_VALUES;
        }

        return TimePickerClockPresenter.HOUR_CLOCK_VALUES;
    }

    private int getHourRotation() {
        return this.time.getHourForDisplay() * 30 % 360;
    }

    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    public void initialize() {
        if(this.time.format == 0) {
            this.timePickerView.showToggle();
        }

        this.timePickerView.addOnRotateListener(((OnRotateListener)this));
        this.timePickerView.setOnSelectionChangeListener(((OnSelectionChange)this));
        this.timePickerView.setOnPeriodChangeListener(((OnPeriodChangeListener)this));
        this.timePickerView.setOnActionUpListener(((OnActionUpListener)this));
        this.updateValues();
        this.invalidate();
    }

    public void invalidate() {
        this.hourRotation = ((float)this.getHourRotation());
        this.minuteRotation = ((float)(this.time.minute * 6));
        this.setSelection(this.time.selection, false);
        this.updateTime();
    }

    public void onActionUp(float arg7, boolean arg8) {
        this.broadcasting = true;
        int v1 = this.time.minute;
        int v2 = this.time.hour;
        if(this.time.selection == 10) {
            this.timePickerView.setHandRotation(this.hourRotation, false);
            Object v7 = ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class);
            if(v7 != null && (((AccessibilityManager)v7).isTouchExplorationEnabled())) {
                goto label_40;
            }

            this.setSelection(12, true);
        }
        else {
            int v7_1 = Math.round(arg7);
            if(!arg8) {
                this.time.setMinute((v7_1 + 15) / 30 * 5);
                this.minuteRotation = ((float)(this.time.minute * 6));
            }

            this.timePickerView.setHandRotation(this.minuteRotation, arg8);
        }

    label_40:
        this.broadcasting = false;
        this.updateTime();
        this.performHapticFeedback(v2, v1);
    }

    public void onPeriodChange(int arg1) {
        this.time.setPeriod(arg1);
    }

    public void onRotate(float arg5, boolean arg6) {
        if(this.broadcasting) {
        }
        else {
            int v0 = this.time.hour;
            int v1 = this.time.minute;
            int v5 = Math.round(arg5);
            if(this.time.selection == 12) {
                this.time.setMinute((v5 + 3) / 6);
                this.minuteRotation = ((float)Math.floor(((double)(this.time.minute * 6))));
            }
            else {
                v5 = (v5 + 15) / 30;
                if(this.time.format == 1) {
                    v5 %= 12;
                    if(this.timePickerView.getCurrentLevel() == 2) {
                        v5 += 12;
                    }
                }

                this.time.setHour(v5);
                this.hourRotation = ((float)this.getHourRotation());
            }

            if(arg6) {
                return;
            }

            this.updateTime();
            this.performHapticFeedback(v0, v1);
        }
    }

    public void onSelectionChanged(int arg2) {
        this.setSelection(arg2, true);
    }

    private void performHapticFeedback(int arg2, int arg3) {
        if(this.time.minute == arg3) {
            if(this.time.hour != arg2) {
            }
            else {
                return;
            }
        }

        this.timePickerView.performHapticFeedback(4);
    }

    void setSelection(int arg5, boolean arg6) {
        boolean v0 = arg5 == 12 ? true : false;
        this.timePickerView.setAnimateOnTouchUp(v0);
        this.time.selection = arg5;
        TimePickerView v1 = this.timePickerView;
        String[] v2 = v0 ? TimePickerClockPresenter.MINUTE_CLOCK_VALUES : this.getHourClockValues();
        int v3 = v0 ? string.material_minute_suffix : this.time.getHourContentDescriptionResId();
        v1.setValues(v2, v3);
        this.updateCurrentLevel();
        v1 = this.timePickerView;
        float v0_1 = v0 ? this.minuteRotation : this.hourRotation;
        v1.setHandRotation(v0_1, arg6);
        this.timePickerView.setActiveSelection(arg5);
        this.timePickerView.setMinuteHourDelegate(new ClickActionDelegate(this.timePickerView.getContext(), string.material_hour_selection) {
            public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
                super.onInitializeAccessibilityNodeInfo(arg2, arg3);
                arg3.setContentDescription(arg2.getResources().getString(TimePickerClockPresenter.this.time.getHourContentDescriptionResId(), new Object[]{String.valueOf(TimePickerClockPresenter.this.time.getHourForDisplay())}));
            }
        });
        this.timePickerView.setHourClickDelegate(new ClickActionDelegate(this.timePickerView.getContext(), string.material_minute_selection) {
            public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
                super.onInitializeAccessibilityNodeInfo(arg2, arg3);
                arg3.setContentDescription(arg2.getResources().getString(string.material_minute_suffix, new Object[]{String.valueOf(TimePickerClockPresenter.this.time.minute)}));
            }
        });
    }

    public void show() {
        this.timePickerView.setVisibility(0);
    }

    private void updateCurrentLevel() {
        int v2 = 1;
        if(this.time.selection == 10 && this.time.format == 1 && this.time.hour >= 12) {
            v2 = 2;
        }

        this.timePickerView.setCurrentLevel(v2);
    }

    private void updateTime() {
        this.timePickerView.updateTime(this.time.period, this.time.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        this.updateValues(TimePickerClockPresenter.HOUR_CLOCK_VALUES, "%d");
        this.updateValues(TimePickerClockPresenter.MINUTE_CLOCK_VALUES, "%02d");
    }

    private void updateValues(String[] arg4, String arg5) {
        int v0;
        for(v0 = 0; v0 < arg4.length; ++v0) {
            arg4[v0] = TimeModel.formatText(this.timePickerView.getResources(), arg4[v0], arg5);
        }
    }
}

