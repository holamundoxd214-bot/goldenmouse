package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker extends DialogFragment implements OnDoubleTapListener {
    public final class Builder {
        private Integer inputMode;
        private CharSequence negativeButtonText;
        private int negativeButtonTextResId;
        private int overrideThemeResId;
        private CharSequence positiveButtonText;
        private int positiveButtonTextResId;
        private TimeModel time;
        private CharSequence titleText;
        private int titleTextResId;

        public Builder() {
            super();
            this.time = new TimeModel();
            this.titleTextResId = 0;
            this.positiveButtonTextResId = 0;
            this.negativeButtonTextResId = 0;
            this.overrideThemeResId = 0;
        }

        static TimeModel access$000(Builder arg0) {
            return arg0.time;
        }

        static Integer access$100(Builder arg0) {
            return arg0.inputMode;
        }

        static int access$200(Builder arg0) {
            return arg0.titleTextResId;
        }

        static CharSequence access$300(Builder arg0) {
            return arg0.titleText;
        }

        static int access$400(Builder arg0) {
            return arg0.positiveButtonTextResId;
        }

        static CharSequence access$500(Builder arg0) {
            return arg0.positiveButtonText;
        }

        static int access$600(Builder arg0) {
            return arg0.negativeButtonTextResId;
        }

        static CharSequence access$700(Builder arg0) {
            return arg0.negativeButtonText;
        }

        static int access$800(Builder arg0) {
            return arg0.overrideThemeResId;
        }

        public MaterialTimePicker build() {
            return MaterialTimePicker.newInstance(this);
        }

        public Builder setHour(int arg2) {
            this.time.setHourOfDay(arg2);
            return this;
        }

        public Builder setInputMode(int arg1) {
            this.inputMode = Integer.valueOf(arg1);
            return this;
        }

        public Builder setMinute(int arg2) {
            this.time.setMinute(arg2);
            return this;
        }

        public Builder setNegativeButtonText(int arg1) {
            this.negativeButtonTextResId = arg1;
            return this;
        }

        public Builder setNegativeButtonText(CharSequence arg1) {
            this.negativeButtonText = arg1;
            return this;
        }

        public Builder setPositiveButtonText(int arg1) {
            this.positiveButtonTextResId = arg1;
            return this;
        }

        public Builder setPositiveButtonText(CharSequence arg1) {
            this.positiveButtonText = arg1;
            return this;
        }

        public Builder setTheme(int arg1) {
            this.overrideThemeResId = arg1;
            return this;
        }

        public Builder setTimeFormat(int arg4) {
            int v0 = this.time.hour;
            int v1 = this.time.minute;
            TimeModel v2 = new TimeModel(arg4);
            this.time = v2;
            v2.setMinute(v1);
            this.time.setHourOfDay(v0);
            return this;
        }

        public Builder setTitleText(int arg1) {
            this.titleTextResId = arg1;
            return this;
        }

        public Builder setTitleText(CharSequence arg1) {
            this.titleText = arg1;
            return this;
        }
    }

    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    private TimePickerPresenter activePresenter;
    private Button cancelButton;
    private final Set cancelListeners;
    private int clockIcon;
    private final Set dismissListeners;
    private int inputMode;
    private int keyboardIcon;
    private MaterialButton modeButton;
    private final Set negativeButtonListeners;
    private CharSequence negativeButtonText;
    private int negativeButtonTextResId;
    private int overrideThemeResId;
    private final Set positiveButtonListeners;
    private CharSequence positiveButtonText;
    private int positiveButtonTextResId;
    private ViewStub textInputStub;
    private TimeModel time;
    private TimePickerClockPresenter timePickerClockPresenter;
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private int titleResId;
    private CharSequence titleText;

    public MaterialTimePicker() {
        super();
        this.positiveButtonListeners = new LinkedHashSet();
        this.negativeButtonListeners = new LinkedHashSet();
        this.cancelListeners = new LinkedHashSet();
        this.dismissListeners = new LinkedHashSet();
        this.titleResId = 0;
        this.positiveButtonTextResId = 0;
        this.negativeButtonTextResId = 0;
        this.inputMode = 0;
        this.overrideThemeResId = 0;
    }

    static Set access$1000(MaterialTimePicker arg0) {
        return arg0.negativeButtonListeners;
    }

    static int access$1100(MaterialTimePicker arg0) {
        return arg0.inputMode;
    }

    static int access$1102(MaterialTimePicker arg0, int arg1) {
        arg0.inputMode = arg1;
        return arg1;
    }

    static MaterialButton access$1200(MaterialTimePicker arg0) {
        return arg0.modeButton;
    }

    static void access$1300(MaterialTimePicker arg0, MaterialButton arg1) {
        arg0.updateInputMode(arg1);
    }

    static MaterialTimePicker access$1400(Builder arg0) {
        return MaterialTimePicker.newInstance(arg0);
    }

    static Set access$900(MaterialTimePicker arg0) {
        return arg0.positiveButtonListeners;
    }

    public boolean addOnCancelListener(DialogInterface$OnCancelListener arg1) {
        return this.cancelListeners.add(arg1);
    }

    public boolean addOnDismissListener(DialogInterface$OnDismissListener arg1) {
        return this.dismissListeners.add(arg1);
    }

    public boolean addOnNegativeButtonClickListener(View$OnClickListener arg1) {
        return this.negativeButtonListeners.add(arg1);
    }

    public boolean addOnPositiveButtonClickListener(View$OnClickListener arg1) {
        return this.positiveButtonListeners.add(arg1);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    private Pair dataForMode(int arg3) {
        if(arg3 != 0) {
            if(arg3 == 1) {
                return new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(string.material_timepicker_clock_mode_description));
            }

            throw new IllegalArgumentException("no icon for mode: " + arg3);
        }

        return new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(string.material_timepicker_text_input_mode_description));
    }

    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    public int getMinute() {
        return this.time.minute;
    }

    private int getThemeResId() {
        int v0 = this.overrideThemeResId;
        if(v0 != 0) {
            return v0;
        }

        TypedValue v1 = MaterialAttributes.resolve(this.requireContext(), attr.materialTimePickerTheme);
        if(v1 == null) {
            return 0;
        }

        return v1.data;
    }

    TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int arg1, TimePickerView arg2, ViewStub arg3) {
        if(arg1 == 0) {
            TimePickerClockPresenter v1 = this.timePickerClockPresenter;
            if(v1 == null) {
                v1 = new TimePickerClockPresenter(arg2, this.time);
            }

            this.timePickerClockPresenter = v1;
            return ((TimePickerPresenter)v1);
        }

        TimePickerTextInputPresenter v1_1 = this.timePickerTextInputPresenter;
        if(v1_1 == null) {
            TimePickerTextInputPresenter v2 = new TimePickerTextInputPresenter(arg3.inflate(), this.time);
            this.timePickerTextInputPresenter = v2;
            v1_1 = v2;
        }

        v1_1.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    void lambda$onViewCreated$0$com-google-android-material-timepicker-MaterialTimePicker() {
        TimePickerPresenter v1 = this.activePresenter;
        if((v1 instanceof TimePickerTextInputPresenter)) {
            ((TimePickerTextInputPresenter)v1).resetChecked();
        }
    }

    private static MaterialTimePicker newInstance(Builder arg4) {
        MaterialTimePicker v0 = new MaterialTimePicker();
        Bundle v1 = new Bundle();
        v1.putParcelable("TIME_PICKER_TIME_MODEL", Builder.access$000(arg4));
        if(Builder.access$100(arg4) != null) {
            v1.putInt("TIME_PICKER_INPUT_MODE", Builder.access$100(arg4).intValue());
        }

        v1.putInt("TIME_PICKER_TITLE_RES", Builder.access$200(arg4));
        if(Builder.access$300(arg4) != null) {
            v1.putCharSequence("TIME_PICKER_TITLE_TEXT", Builder.access$300(arg4));
        }

        v1.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", Builder.access$400(arg4));
        if(Builder.access$500(arg4) != null) {
            v1.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", Builder.access$500(arg4));
        }

        v1.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", Builder.access$600(arg4));
        if(Builder.access$700(arg4) != null) {
            v1.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", Builder.access$700(arg4));
        }

        v1.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", Builder.access$800(arg4));
        v0.setArguments(v1);
        return v0;
    }

    public final void onCancel(DialogInterface arg3) {
        Iterator v0 = this.cancelListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onCancel(arg3);
        }

        super.onCancel(arg3);
    }

    public void onCreate(Bundle arg1) {
        super.onCreate(arg1);
        if(arg1 == null) {
            arg1 = this.getArguments();
        }

        this.restoreState(arg1);
    }

    public final Dialog onCreateDialog(Bundle arg7) {
        Dialog v7 = new Dialog(this.requireContext(), this.getThemeResId());
        Context v0 = v7.getContext();
        MaterialShapeDrawable v1 = new MaterialShapeDrawable(v0, null, attr.materialTimePickerStyle, style.Widget_MaterialComponents_TimePicker);
        TypedArray v2 = v0.obtainStyledAttributes(null, styleable.MaterialTimePicker, attr.materialTimePickerStyle, style.Widget_MaterialComponents_TimePicker);
        this.clockIcon = v2.getResourceId(styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = v2.getResourceId(styleable.MaterialTimePicker_keyboardIcon, 0);
        int v6 = v2.getColor(styleable.MaterialTimePicker_backgroundTint, 0);
        v2.recycle();
        v1.initializeElevationOverlay(v0);
        v1.setFillColor(ColorStateList.valueOf(v6));
        Window v6_1 = v7.getWindow();
        v6_1.setBackgroundDrawable(((Drawable)v1));
        v6_1.requestFeature(1);
        v6_1.setLayout(-2, -2);
        v1.setElevation(ViewCompat.getElevation(v6_1.getDecorView()));
        return v7;
    }

    public final View onCreateView(LayoutInflater arg1, ViewGroup arg2, Bundle arg3) {
        View v1 = arg1.inflate(layout.material_timepicker_dialog, arg2);
        View v2 = ((ViewGroup)v1).findViewById(id.material_timepicker_view);
        this.timePickerView = ((TimePickerView)v2);
        ((TimePickerView)v2).setOnDoubleTapListener(((OnDoubleTapListener)this));
        this.textInputStub = ((ViewGroup)v1).findViewById(id.material_textinput_timepicker);
        this.modeButton = ((ViewGroup)v1).findViewById(id.material_timepicker_mode_button);
        v2 = ((ViewGroup)v1).findViewById(id.header_title);
        int v3 = this.titleResId;
        if(v3 != 0) {
            ((TextView)v2).setText(v3);
        }
        else if(!TextUtils.isEmpty(this.titleText)) {
            ((TextView)v2).setText(this.titleText);
        }

        this.updateInputMode(this.modeButton);
        v2 = ((ViewGroup)v1).findViewById(id.material_timepicker_ok_button);
        ((Button)v2).setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg3) {
                Iterator v0 = MaterialTimePicker.this.positiveButtonListeners.iterator();
                while(v0.hasNext()) {
                    v0.next().onClick(arg3);
                }

                MaterialTimePicker.this.dismiss();
            }
        });
        v3 = this.positiveButtonTextResId;
        if(v3 != 0) {
            ((Button)v2).setText(v3);
        }
        else if(!TextUtils.isEmpty(this.positiveButtonText)) {
            ((Button)v2).setText(this.positiveButtonText);
        }

        v2 = ((ViewGroup)v1).findViewById(id.material_timepicker_cancel_button);
        this.cancelButton = ((Button)v2);
        ((Button)v2).setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg3) {
                Iterator v0 = MaterialTimePicker.this.negativeButtonListeners.iterator();
                while(v0.hasNext()) {
                    v0.next().onClick(arg3);
                }

                MaterialTimePicker.this.dismiss();
            }
        });
        int v2_1 = this.negativeButtonTextResId;
        if(v2_1 != 0) {
            this.cancelButton.setText(v2_1);
        }
        else if(!TextUtils.isEmpty(this.negativeButtonText)) {
            this.cancelButton.setText(this.negativeButtonText);
        }

        this.updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg2) {
                MaterialTimePicker v2 = MaterialTimePicker.this;
                int v0 = v2.inputMode == 0 ? 1 : 0;
                v2.inputMode = v0;
                MaterialTimePicker.this.updateInputMode(MaterialTimePicker.this.modeButton);
            }
        });
        return v1;
    }

    public void onDestroyView() {
        super.onDestroyView();
        TimePickerPresenter v0 = null;
        this.activePresenter = v0;
        this.timePickerClockPresenter = ((TimePickerClockPresenter)v0);
        this.timePickerTextInputPresenter = ((TimePickerTextInputPresenter)v0);
        TimePickerView v1 = this.timePickerView;
        if(v1 != null) {
            v1.setOnDoubleTapListener(((OnDoubleTapListener)v0));
            this.timePickerView = ((TimePickerView)v0);
        }
    }

    public final void onDismiss(DialogInterface arg3) {
        Iterator v0 = this.dismissListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onDismiss(arg3);
        }

        super.onDismiss(arg3);
    }

    public void onDoubleTap() {
        this.inputMode = 1;
        this.updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.resetChecked();
    }

    public void onSaveInstanceState(Bundle arg3) {
        super.onSaveInstanceState(arg3);
        arg3.putParcelable("TIME_PICKER_TIME_MODEL", this.time);
        arg3.putInt("TIME_PICKER_INPUT_MODE", this.inputMode);
        arg3.putInt("TIME_PICKER_TITLE_RES", this.titleResId);
        arg3.putCharSequence("TIME_PICKER_TITLE_TEXT", this.titleText);
        arg3.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.positiveButtonTextResId);
        arg3.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.positiveButtonText);
        arg3.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.negativeButtonTextResId);
        arg3.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.negativeButtonText);
        arg3.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
    }

    public void onViewCreated(View arg3, Bundle arg4) {
        super.onViewCreated(arg3, arg4);
        if((this.activePresenter instanceof TimePickerTextInputPresenter)) {
            arg3.postDelayed(new MaterialTimePicker$$ExternalSyntheticLambda0(this), 100);
        }
    }

    public boolean removeOnCancelListener(DialogInterface$OnCancelListener arg1) {
        return this.cancelListeners.remove(arg1);
    }

    public boolean removeOnDismissListener(DialogInterface$OnDismissListener arg1) {
        return this.dismissListeners.remove(arg1);
    }

    public boolean removeOnNegativeButtonClickListener(View$OnClickListener arg1) {
        return this.negativeButtonListeners.remove(arg1);
    }

    public boolean removeOnPositiveButtonClickListener(View$OnClickListener arg1) {
        return this.positiveButtonListeners.remove(arg1);
    }

    private void restoreState(Bundle arg4) {
        if(arg4 == null) {
            return;
        }

        Parcelable v0 = arg4.getParcelable("TIME_PICKER_TIME_MODEL");
        this.time = ((TimeModel)v0);
        if(v0 == null) {
            TimeModel v0_1 = new TimeModel();
            this.time = v0_1;
        }

        int v1 = 1;
        if(((TimeModel)v0).format == 1) {
        }
        else {
            v1 = 0;
        }

        this.inputMode = arg4.getInt("TIME_PICKER_INPUT_MODE", v1);
        this.titleResId = arg4.getInt("TIME_PICKER_TITLE_RES", 0);
        this.titleText = arg4.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.positiveButtonTextResId = arg4.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.positiveButtonText = arg4.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.negativeButtonTextResId = arg4.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.negativeButtonText = arg4.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.overrideThemeResId = arg4.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    void setActivePresenter(TimePickerPresenter arg1) {
        this.activePresenter = arg1;
    }

    public void setCancelable(boolean arg1) {
        super.setCancelable(arg1);
        this.updateCancelButtonVisibility();
    }

    public void setHour(int arg2) {
        this.time.setHour(arg2);
        TimePickerPresenter v1 = this.activePresenter;
        if(v1 != null) {
            v1.invalidate();
        }
    }

    public void setMinute(int arg2) {
        this.time.setMinute(arg2);
        TimePickerPresenter v1 = this.activePresenter;
        if(v1 != null) {
            v1.invalidate();
        }
    }

    private void updateCancelButtonVisibility() {
        Button v0 = this.cancelButton;
        if(v0 != null) {
            int v1 = this.isCancelable() ? 0 : 8;
            v0.setVisibility(v1);
        }
    }

    private void updateInputMode(MaterialButton arg4) {
        if(arg4 != null && this.timePickerView != null) {
            if(this.textInputStub == null) {
            }
            else {
                TimePickerPresenter v0 = this.activePresenter;
                if(v0 != null) {
                    v0.hide();
                }

                v0 = this.initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
                this.activePresenter = v0;
                v0.show();
                this.activePresenter.invalidate();
                Pair v0_1 = this.dataForMode(this.inputMode);
                arg4.setIconResource(v0_1.first.intValue());
                arg4.setContentDescription(this.getResources().getString(v0_1.second.intValue()));
                arg4.sendAccessibilityEvent(4);
            }
        }
    }
}

