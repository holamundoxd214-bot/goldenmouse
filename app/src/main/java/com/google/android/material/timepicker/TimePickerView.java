package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View$OnClickListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    class com.google.android.material.timepicker.TimePickerView$1 implements View$OnClickListener {
        com.google.android.material.timepicker.TimePickerView$1(TimePickerView arg1) {
            TimePickerView.this = arg1;
            super();
        }

        public void onClick(View arg2) {
            if(TimePickerView.this.onSelectionChangeListener != null) {
                TimePickerView.this.onSelectionChangeListener.onSelectionChanged(arg2.getTag(id.selection_type).intValue());
            }
        }
    }

    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    interface OnPeriodChangeListener {
        void onPeriodChange(int arg1);
    }

    interface OnSelectionChange {
        void onSelectionChanged(int arg1);
    }

    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    private OnSelectionChange onSelectionChangeListener;
    private final View$OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    public TimePickerView(Context arg2) {
        this(arg2, null);
    }

    public TimePickerView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public TimePickerView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.selectionListener = new com.google.android.material.timepicker.TimePickerView$1(this);
        LayoutInflater.from(arg1).inflate(layout.material_timepicker, ((ViewGroup)this));
        this.clockFace = this.findViewById(id.material_clock_face);
        View v1 = this.findViewById(id.material_clock_period_toggle);
        this.toggle = ((MaterialButtonToggleGroup)v1);
        ((MaterialButtonToggleGroup)v1).addOnButtonCheckedListener(new TimePickerView$$ExternalSyntheticLambda0(this));
        this.minuteView = this.findViewById(id.material_minute_tv);
        this.hourView = this.findViewById(id.material_hour_tv);
        this.clockHandView = this.findViewById(id.material_clock_hand);
        this.setupDoubleTap();
        this.setUpDisplay();
    }

    static OnSelectionChange access$000(TimePickerView arg0) {
        return arg0.onSelectionChangeListener;
    }

    static OnDoubleTapListener access$100(TimePickerView arg0) {
        return arg0.onDoubleTapListener;
    }

    public void addOnRotateListener(OnRotateListener arg1) {
        this.clockHandView.addOnRotateListener(arg1);
    }

    int getCurrentLevel() {
        return this.clockFace.getCurrentLevel();
    }

    void lambda$new$0$com-google-android-material-timepicker-TimePickerView(MaterialButtonToggleGroup arg1, int arg2, boolean arg3) {
        if(!arg3) {
        }
        else if(this.onPeriodChangeListener != null) {
            int v1 = arg2 == id.material_clock_period_pm_button ? 1 : 0;
            this.onPeriodChangeListener.onPeriodChange(v1);
        }
    }

    protected void onVisibilityChanged(View arg1, int arg2) {
        super.onVisibilityChanged(arg1, arg2);
        if((((TimePickerView)arg1)) == this && arg2 == 0) {
            this.hourView.sendAccessibilityEvent(8);
        }
    }

    public void setActiveSelection(int arg5) {
        Chip v0 = this.minuteView;
        boolean v2 = true;
        boolean v1 = arg5 == 12 ? true : false;
        this.updateSelection(v0, v1);
        v0 = this.hourView;
        if(arg5 == 10) {
        }
        else {
            v2 = false;
        }

        this.updateSelection(v0, v2);
    }

    public void setAnimateOnTouchUp(boolean arg1) {
        this.clockHandView.setAnimateOnTouchUp(arg1);
    }

    void setCurrentLevel(int arg1) {
        this.clockFace.setCurrentLevel(arg1);
    }

    public void setHandRotation(float arg1, boolean arg2) {
        this.clockHandView.setHandRotation(arg1, arg2);
    }

    public void setHandRotation(float arg1) {
        this.clockHandView.setHandRotation(arg1);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat arg1) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, arg1);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat arg1) {
        ViewCompat.setAccessibilityDelegate(this.hourView, arg1);
    }

    public void setOnActionUpListener(OnActionUpListener arg1) {
        this.clockHandView.setOnActionUpListener(arg1);
    }

    void setOnDoubleTapListener(OnDoubleTapListener arg1) {
        this.onDoubleTapListener = arg1;
    }

    void setOnPeriodChangeListener(OnPeriodChangeListener arg1) {
        this.onPeriodChangeListener = arg1;
    }

    void setOnSelectionChangeListener(OnSelectionChange arg1) {
        this.onSelectionChangeListener = arg1;
    }

    private void setUpDisplay() {
        this.minuteView.setTag(id.selection_type, Integer.valueOf(12));
        this.hourView.setTag(id.selection_type, Integer.valueOf(10));
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName("android.view.View");
        this.hourView.setAccessibilityClassName("android.view.View");
    }

    public void setValues(String[] arg1, int arg2) {
        this.clockFace.setValues(arg1, arg2);
    }

    private void setupDoubleTap() {
        com.google.android.material.timepicker.TimePickerView$3 v1 = new View$OnTouchListener(new GestureDetector(this.getContext(), new GestureDetector$SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent arg1) {
                OnDoubleTapListener v0 = TimePickerView.this.onDoubleTapListener;
                if(v0 != null) {
                    v0.onDoubleTap();
                    return 1;
                }

                return 0;
            }
        })) {
            public boolean onTouch(View arg1, MotionEvent arg2) {
                if(((Checkable)arg1).isChecked()) {
                    return this.val$gestureDetector.onTouchEvent(arg2);
                }

                return 0;
            }
        };
        this.minuteView.setOnTouchListener(((View$OnTouchListener)v1));
        this.hourView.setOnTouchListener(((View$OnTouchListener)v1));
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    private void updateSelection(Chip arg1, boolean arg2) {
        arg1.setChecked(arg2);
        int v0 = arg2 ? 2 : 0;
        ViewCompat.setAccessibilityLiveRegion(((View)arg1), v0);
    }

    public void updateTime(int arg2, int arg3, int arg4) {
        arg2 = arg2 == 1 ? id.material_clock_period_pm_button : id.material_clock_period_am_button;
        this.toggle.check(arg2);
        Locale v2 = this.getResources().getConfiguration().locale;
        String v4 = String.format(v2, "%02d", Integer.valueOf(arg4));
        String v2_1 = String.format(v2, "%02d", Integer.valueOf(arg3));
        if(!TextUtils.equals(this.minuteView.getText(), ((CharSequence)v4))) {
            this.minuteView.setText(((CharSequence)v4));
        }

        if(!TextUtils.equals(this.hourView.getText(), ((CharSequence)v2_1))) {
            this.hourView.setText(((CharSequence)v2_1));
        }
    }
}

