package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout$LayoutParams;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker extends DialogFragment {
    public final class Builder {
        CalendarConstraints calendarConstraints;
        final DateSelector dateSelector;
        DayViewDecorator dayViewDecorator;
        int inputMode;
        CharSequence negativeButtonContentDescription;
        int negativeButtonContentDescriptionResId;
        CharSequence negativeButtonText;
        int negativeButtonTextResId;
        int overrideThemeResId;
        CharSequence positiveButtonContentDescription;
        int positiveButtonContentDescriptionResId;
        CharSequence positiveButtonText;
        int positiveButtonTextResId;
        Object selection;
        CharSequence titleText;
        int titleTextResId;

        private Builder(DateSelector arg3) {
            super();
            this.overrideThemeResId = 0;
            this.titleTextResId = 0;
            this.titleText = null;
            this.positiveButtonTextResId = 0;
            this.positiveButtonText = null;
            this.positiveButtonContentDescriptionResId = 0;
            this.positiveButtonContentDescription = null;
            this.negativeButtonTextResId = 0;
            this.negativeButtonText = null;
            this.negativeButtonContentDescriptionResId = 0;
            this.negativeButtonContentDescription = null;
            this.selection = null;
            this.inputMode = 0;
            this.dateSelector = arg3;
        }

        public MaterialDatePicker build() {
            if(this.calendarConstraints == null) {
                this.calendarConstraints = new com.google.android.material.datepicker.CalendarConstraints$Builder().build();
            }

            if(this.titleTextResId == 0) {
                this.titleTextResId = this.dateSelector.getDefaultTitleResId();
            }

            Object v0 = this.selection;
            if(v0 != null) {
                this.dateSelector.setSelection(v0);
            }

            if(this.calendarConstraints.getOpenAt() == null) {
                this.calendarConstraints.setOpenAt(this.createDefaultOpenAt());
            }

            return MaterialDatePicker.newInstance(this);
        }

        private Month createDefaultOpenAt() {
            Month v0;
            if(!this.dateSelector.getSelectedDays().isEmpty()) {
                v0 = Month.create(this.dateSelector.getSelectedDays().iterator().next().longValue());
                if(Builder.monthInValidRange(v0, this.calendarConstraints)) {
                    return v0;
                }
            }

            v0 = Month.current();
            if(Builder.monthInValidRange(v0, this.calendarConstraints)) {
                return v0;
            }

            return this.calendarConstraints.getStart();
        }

        public static Builder customDatePicker(DateSelector arg1) {
            return new Builder(arg1);
        }

        public static Builder datePicker() {
            return new Builder(new SingleDateSelector());
        }

        public static Builder dateRangePicker() {
            return new Builder(new RangeDateSelector());
        }

        private static boolean monthInValidRange(Month arg1, CalendarConstraints arg2) {
            if(arg1.compareTo(arg2.getStart()) >= 0 && arg1.compareTo(arg2.getEnd()) <= 0) {
                return 1;
            }

            return 0;
        }

        public Builder setCalendarConstraints(CalendarConstraints arg1) {
            this.calendarConstraints = arg1;
            return this;
        }

        public Builder setDayViewDecorator(DayViewDecorator arg1) {
            this.dayViewDecorator = arg1;
            return this;
        }

        public Builder setInputMode(int arg1) {
            this.inputMode = arg1;
            return this;
        }

        public Builder setNegativeButtonContentDescription(int arg1) {
            this.negativeButtonContentDescriptionResId = arg1;
            this.negativeButtonContentDescription = null;
            return this;
        }

        public Builder setNegativeButtonContentDescription(CharSequence arg1) {
            this.negativeButtonContentDescription = arg1;
            this.negativeButtonContentDescriptionResId = 0;
            return this;
        }

        public Builder setNegativeButtonText(int arg1) {
            this.negativeButtonTextResId = arg1;
            this.negativeButtonText = null;
            return this;
        }

        public Builder setNegativeButtonText(CharSequence arg1) {
            this.negativeButtonText = arg1;
            this.negativeButtonTextResId = 0;
            return this;
        }

        public Builder setPositiveButtonContentDescription(int arg1) {
            this.positiveButtonContentDescriptionResId = arg1;
            this.positiveButtonContentDescription = null;
            return this;
        }

        public Builder setPositiveButtonContentDescription(CharSequence arg1) {
            this.positiveButtonContentDescription = arg1;
            this.positiveButtonContentDescriptionResId = 0;
            return this;
        }

        public Builder setPositiveButtonText(int arg1) {
            this.positiveButtonTextResId = arg1;
            this.positiveButtonText = null;
            return this;
        }

        public Builder setPositiveButtonText(CharSequence arg1) {
            this.positiveButtonText = arg1;
            this.positiveButtonTextResId = 0;
            return this;
        }

        public Builder setSelection(Object arg1) {
            this.selection = arg1;
            return this;
        }

        public Builder setTextInputFormat(SimpleDateFormat arg2) {
            this.dateSelector.setTextInputFormat(arg2);
            return this;
        }

        public Builder setTheme(int arg1) {
            this.overrideThemeResId = arg1;
            return this;
        }

        public Builder setTitleText(int arg1) {
            this.titleTextResId = arg1;
            this.titleText = null;
            return this;
        }

        public Builder setTitleText(CharSequence arg1) {
            this.titleText = arg1;
            this.titleTextResId = 0;
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface InputMode {
    }

    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = null;
    static final Object CONFIRM_BUTTON_TAG = null;
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String POSITIVE_BUTTON_TEXT_KEY = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String POSITIVE_BUTTON_TEXT_RES_ID_KEY = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    static final Object TOGGLE_BUTTON_TAG;
    private MaterialShapeDrawable background;
    private MaterialCalendar calendar;
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;
    private DateSelector dateSelector;
    private DayViewDecorator dayViewDecorator;
    private boolean edgeToEdgeEnabled;
    private CharSequence fullTitleText;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private TextView headerTitleTextView;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonContentDescription;
    private int negativeButtonContentDescriptionResId;
    private CharSequence negativeButtonText;
    private int negativeButtonTextResId;
    private final LinkedHashSet onCancelListeners;
    private final LinkedHashSet onDismissListeners;
    private final LinkedHashSet onNegativeButtonClickListeners;
    private final LinkedHashSet onPositiveButtonClickListeners;
    private int overrideThemeResId;
    private PickerFragment pickerFragment;
    private CharSequence positiveButtonContentDescription;
    private int positiveButtonContentDescriptionResId;
    private CharSequence positiveButtonText;
    private int positiveButtonTextResId;
    private CharSequence singleLineTitleText;
    private CharSequence titleText;
    private int titleTextResId;

    static {
        MaterialDatePicker.CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
        MaterialDatePicker.CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
        MaterialDatePicker.TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    }

    public MaterialDatePicker() {
        super();
        this.onPositiveButtonClickListeners = new LinkedHashSet();
        this.onNegativeButtonClickListeners = new LinkedHashSet();
        this.onCancelListeners = new LinkedHashSet();
        this.onDismissListeners = new LinkedHashSet();
    }

    static LinkedHashSet access$000(MaterialDatePicker arg0) {
        return arg0.onPositiveButtonClickListeners;
    }

    static LinkedHashSet access$100(MaterialDatePicker arg0) {
        return arg0.onNegativeButtonClickListeners;
    }

    static DateSelector access$200(MaterialDatePicker arg0) {
        return arg0.getDateSelector();
    }

    static Button access$300(MaterialDatePicker arg0) {
        return arg0.confirmButton;
    }

    public boolean addOnCancelListener(DialogInterface$OnCancelListener arg1) {
        return this.onCancelListeners.add(arg1);
    }

    public boolean addOnDismissListener(DialogInterface$OnDismissListener arg1) {
        return this.onDismissListeners.add(arg1);
    }

    public boolean addOnNegativeButtonClickListener(View$OnClickListener arg1) {
        return this.onNegativeButtonClickListeners.add(arg1);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener arg1) {
        return this.onPositiveButtonClickListeners.add(arg1);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    private static Drawable createHeaderToggleDrawable(Context arg3) {
        StateListDrawable v0 = new StateListDrawable();
        v0.addState(new int[]{0x10100A0}, AppCompatResources.getDrawable(arg3, drawable.material_ic_calendar_black_24dp));
        v0.addState(new int[0], AppCompatResources.getDrawable(arg3, drawable.material_ic_edit_black_24dp));
        return ((Drawable)v0);
    }

    private void enableEdgeToEdgeIfNeeded(Window arg5) {
        if(this.edgeToEdgeEnabled) {
            return;
        }

        View v0 = this.requireView().findViewById(id.fullscreen_header);
        EdgeToEdgeUtils.applyEdgeToEdge(arg5, true, ViewUtils.getBackgroundColor(v0), null);
        ViewCompat.setOnApplyWindowInsetsListener(v0, new OnApplyWindowInsetsListener(v0.getLayoutParams().height, v0, v0.getPaddingTop()) {
            public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5) {
                int v4 = arg5.getInsets(Type.systemBars()).top;
                if(this.val$originalHeaderHeight >= 0) {
                    this.val$headerLayout.getLayoutParams().height = this.val$originalHeaderHeight + v4;
                    this.val$headerLayout.setLayoutParams(this.val$headerLayout.getLayoutParams());
                }

                this.val$headerLayout.setPadding(this.val$headerLayout.getPaddingLeft(), this.val$originalPaddingTop + v4, this.val$headerLayout.getPaddingRight(), this.val$headerLayout.getPaddingBottom());
                return arg5;
            }
        });
        this.edgeToEdgeEnabled = true;
    }

    private DateSelector getDateSelector() {
        Parcelable v0_1;
        DateSelector v0 = this.dateSelector;
        if(v0 == null) {
            v0_1 = this.getArguments().getParcelable("DATE_SELECTOR_KEY");
            this.dateSelector = ((DateSelector)v0_1);
        }

        return ((DateSelector)v0_1);
    }

    private static CharSequence getFirstLineBySeparator(CharSequence arg3) {
        String v3;
        if(arg3 != null) {
            String[] v0 = TextUtils.split(String.valueOf(arg3), "\n");
            if(v0.length > 1) {
                v3 = v0[0];
            }

            return ((CharSequence)v3);
        }

        return null;
    }

    private String getHeaderContentDescription() {
        return this.getDateSelector().getSelectionContentDescription(this.requireContext());
    }

    public String getHeaderText() {
        return this.getDateSelector().getSelectionDisplayString(this.getContext());
    }

    public int getInputMode() {
        return this.inputMode;
    }

    private static int getPaddedPickerWidth(Context arg4) {
        Resources v4 = arg4.getResources();
        int v0 = v4.getDimensionPixelOffset(dimen.mtrl_calendar_content_padding);
        int v1 = Month.current().daysInWeek;
        return v0 * 2 + v4.getDimensionPixelSize(dimen.mtrl_calendar_day_width) * v1 + (v1 - 1) * v4.getDimensionPixelOffset(dimen.mtrl_calendar_month_horizontal_padding);
    }

    public final Object getSelection() {
        return this.getDateSelector().getSelection();
    }

    private int getThemeResId(Context arg2) {
        int v0 = this.overrideThemeResId;
        if(v0 != 0) {
            return v0;
        }

        return this.getDateSelector().getDefaultThemeResId(arg2);
    }

    private void initHeaderToggle(Context arg3) {
        this.headerToggleButton.setTag(MaterialDatePicker.TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(MaterialDatePicker.createHeaderToggleDrawable(arg3));
        CheckableImageButton v3 = this.headerToggleButton;
        boolean v0 = this.inputMode != 0 ? true : false;
        v3.setChecked(v0);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        this.updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new MaterialDatePicker$$ExternalSyntheticLambda0(this));
    }

    static boolean isFullscreen(Context arg1) {
        return MaterialDatePicker.readMaterialCalendarStyleBoolean(arg1, 0x101020D);
    }

    private boolean isLandscape() {
        if(this.getResources().getConfiguration().orientation == 2) {
            return 1;
        }

        return 0;
    }

    static boolean isNestedScrollable(Context arg1) {
        return MaterialDatePicker.readMaterialCalendarStyleBoolean(arg1, attr.nestedScrollable);
    }

    void lambda$initHeaderToggle$0$com-google-android-material-datepicker-MaterialDatePicker(View arg2) {
        this.confirmButton.setEnabled(this.getDateSelector().isSelectionComplete());
        this.headerToggleButton.toggle();
        int v0 = 1;
        if(this.inputMode == 1) {
            v0 = 0;
        }

        this.inputMode = v0;
        this.updateToggleContentDescription(this.headerToggleButton);
        this.startPickerFragment();
    }

    static MaterialDatePicker newInstance(Builder arg4) {
        MaterialDatePicker v0 = new MaterialDatePicker();
        Bundle v1 = new Bundle();
        v1.putInt("OVERRIDE_THEME_RES_ID", arg4.overrideThemeResId);
        v1.putParcelable("DATE_SELECTOR_KEY", arg4.dateSelector);
        v1.putParcelable("CALENDAR_CONSTRAINTS_KEY", arg4.calendarConstraints);
        v1.putParcelable("DAY_VIEW_DECORATOR_KEY", arg4.dayViewDecorator);
        v1.putInt("TITLE_TEXT_RES_ID_KEY", arg4.titleTextResId);
        v1.putCharSequence("TITLE_TEXT_KEY", arg4.titleText);
        v1.putInt("INPUT_MODE_KEY", arg4.inputMode);
        v1.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", arg4.positiveButtonTextResId);
        v1.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", arg4.positiveButtonText);
        v1.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", arg4.positiveButtonContentDescriptionResId);
        v1.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", arg4.positiveButtonContentDescription);
        v1.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", arg4.negativeButtonTextResId);
        v1.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", arg4.negativeButtonText);
        v1.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", arg4.negativeButtonContentDescriptionResId);
        v1.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", arg4.negativeButtonContentDescription);
        v0.setArguments(v1);
        return v0;
    }

    public final void onCancel(DialogInterface arg3) {
        Iterator v0 = this.onCancelListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onCancel(arg3);
        }

        super.onCancel(arg3);
    }

    public final void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        if(arg2 == null) {
            arg2 = this.getArguments();
        }

        this.overrideThemeResId = arg2.getInt("OVERRIDE_THEME_RES_ID");
        this.dateSelector = arg2.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = arg2.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.dayViewDecorator = arg2.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.titleTextResId = arg2.getInt("TITLE_TEXT_RES_ID_KEY");
        this.titleText = arg2.getCharSequence("TITLE_TEXT_KEY");
        this.inputMode = arg2.getInt("INPUT_MODE_KEY");
        this.positiveButtonTextResId = arg2.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.positiveButtonText = arg2.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.positiveButtonContentDescriptionResId = arg2.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.positiveButtonContentDescription = arg2.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.negativeButtonTextResId = arg2.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.negativeButtonText = arg2.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.negativeButtonContentDescriptionResId = arg2.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.negativeButtonContentDescription = arg2.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence v2 = this.titleText;
        if(v2 != null) {
        }
        else {
            v2 = this.requireContext().getResources().getText(this.titleTextResId);
        }

        this.fullTitleText = v2;
        this.singleLineTitleText = MaterialDatePicker.getFirstLineBySeparator(v2);
    }

    public final Dialog onCreateDialog(Bundle arg6) {
        Dialog v6 = new Dialog(this.requireContext(), this.getThemeResId(this.requireContext()));
        Context v0 = v6.getContext();
        this.fullscreen = MaterialDatePicker.isFullscreen(v0);
        this.background = new MaterialShapeDrawable(v0, null, attr.materialCalendarStyle, style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray v1 = v0.obtainStyledAttributes(null, styleable.MaterialCalendar, attr.materialCalendarStyle, style.Widget_MaterialComponents_MaterialCalendar);
        int v2 = v1.getColor(styleable.MaterialCalendar_backgroundTint, 0);
        v1.recycle();
        this.background.initializeElevationOverlay(v0);
        this.background.setFillColor(ColorStateList.valueOf(v2));
        this.background.setElevation(ViewCompat.getElevation(v6.getWindow().getDecorView()));
        return v6;
    }

    public final View onCreateView(LayoutInflater arg4, ViewGroup arg5, Bundle arg6) {
        int v6 = this.fullscreen ? layout.mtrl_picker_fullscreen : layout.mtrl_picker_dialog;
        View v4 = arg4.inflate(v6, arg5);
        Context v5 = v4.getContext();
        DayViewDecorator v6_1 = this.dayViewDecorator;
        if(v6_1 != null) {
            v6_1.initialize(v5);
        }

        if(this.fullscreen) {
            v4.findViewById(id.mtrl_calendar_frame).setLayoutParams(new LinearLayout$LayoutParams(MaterialDatePicker.getPaddedPickerWidth(v5), -2));
        }
        else {
            v4.findViewById(id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout$LayoutParams(MaterialDatePicker.getPaddedPickerWidth(v5), -1));
        }

        View v6_2 = v4.findViewById(id.mtrl_picker_header_selection_text);
        this.headerSelectionText = ((TextView)v6_2);
        ViewCompat.setAccessibilityLiveRegion(v6_2, 1);
        this.headerToggleButton = v4.findViewById(id.mtrl_picker_header_toggle);
        this.headerTitleTextView = v4.findViewById(id.mtrl_picker_title_text);
        this.initHeaderToggle(v5);
        this.confirmButton = v4.findViewById(id.confirm_button);
        boolean v5_1 = this.getDateSelector().isSelectionComplete();
        Button v6_3 = this.confirmButton;
        if(v5_1) {
            v6_3.setEnabled(true);
        }
        else {
            v6_3.setEnabled(false);
        }

        this.confirmButton.setTag(MaterialDatePicker.CONFIRM_BUTTON_TAG);
        CharSequence v5_2 = this.positiveButtonText;
        if(v5_2 != null) {
            this.confirmButton.setText(v5_2);
        }
        else {
            int v5_3 = this.positiveButtonTextResId;
            if(v5_3 != 0) {
                this.confirmButton.setText(v5_3);
            }
        }

        v5_2 = this.positiveButtonContentDescription;
        if(v5_2 != null) {
            this.confirmButton.setContentDescription(v5_2);
        }
        else if(this.positiveButtonContentDescriptionResId != 0) {
            this.confirmButton.setContentDescription(this.getContext().getResources().getText(this.positiveButtonContentDescriptionResId));
        }

        this.confirmButton.setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg3) {
                Iterator v3 = MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
                while(v3.hasNext()) {
                    v3.next().onPositiveButtonClick(MaterialDatePicker.this.getSelection());
                }

                MaterialDatePicker.this.dismiss();
            }
        });
        View v5_4 = v4.findViewById(id.cancel_button);
        ((Button)v5_4).setTag(MaterialDatePicker.CANCEL_BUTTON_TAG);
        CharSequence v6_4 = this.negativeButtonText;
        if(v6_4 != null) {
            ((Button)v5_4).setText(v6_4);
        }
        else {
            v6 = this.negativeButtonTextResId;
            if(v6 != 0) {
                ((Button)v5_4).setText(v6);
            }
        }

        v6_4 = this.negativeButtonContentDescription;
        if(v6_4 != null) {
            ((Button)v5_4).setContentDescription(v6_4);
        }
        else if(this.negativeButtonContentDescriptionResId != 0) {
            ((Button)v5_4).setContentDescription(this.getContext().getResources().getText(this.negativeButtonContentDescriptionResId));
        }

        ((Button)v5_4).setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg3) {
                Iterator v0 = MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
                while(v0.hasNext()) {
                    v0.next().onClick(arg3);
                }

                MaterialDatePicker.this.dismiss();
            }
        });
        return v4;
    }

    public final void onDismiss(DialogInterface arg3) {
        Iterator v0 = this.onDismissListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onDismiss(arg3);
        }

        View v0_1 = this.getView();
        if(v0_1 != null) {
            ((ViewGroup)v0_1).removeAllViews();
        }

        super.onDismiss(arg3);
    }

    public final void onSaveInstanceState(Bundle arg4) {
        super.onSaveInstanceState(arg4);
        arg4.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
        arg4.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        com.google.android.material.datepicker.CalendarConstraints$Builder v0 = new com.google.android.material.datepicker.CalendarConstraints$Builder(this.calendarConstraints);
        MaterialCalendar v1 = this.calendar;
        Month v1_1 = v1 == null ? null : v1.getCurrentMonth();
        if(v1_1 != null) {
            v0.setOpenAt(v1_1.timeInMillis);
        }

        arg4.putParcelable("CALENDAR_CONSTRAINTS_KEY", v0.build());
        arg4.putParcelable("DAY_VIEW_DECORATOR_KEY", this.dayViewDecorator);
        arg4.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
        arg4.putCharSequence("TITLE_TEXT_KEY", this.titleText);
        arg4.putInt("INPUT_MODE_KEY", this.inputMode);
        arg4.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.positiveButtonTextResId);
        arg4.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.positiveButtonText);
        arg4.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.positiveButtonContentDescriptionResId);
        arg4.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.positiveButtonContentDescription);
        arg4.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.negativeButtonTextResId);
        arg4.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.negativeButtonText);
        arg4.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.negativeButtonContentDescriptionResId);
        arg4.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.negativeButtonContentDescription);
    }

    public void onStart() {
        super.onStart();
        Window v0 = this.requireDialog().getWindow();
        if(this.fullscreen) {
            v0.setLayout(-1, -1);
            v0.setBackgroundDrawable(this.background);
            this.enableEdgeToEdgeIfNeeded(v0);
        }
        else {
            v0.setLayout(-2, -2);
            int v5 = this.getResources().getDimensionPixelOffset(dimen.mtrl_calendar_dialog_background_inset);
            Rect v1 = new Rect(v5, v5, v5, v5);
            v0.setBackgroundDrawable(new InsetDrawable(this.background, v5, v5, v5, v5));
            v0.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this.requireDialog(), v1));
        }

        this.startPickerFragment();
    }

    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    static boolean readMaterialCalendarStyleBoolean(Context arg2, int arg3) {
        TypedArray v2 = arg2.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(arg2, attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{arg3});
        boolean v3 = v2.getBoolean(0, false);
        v2.recycle();
        return v3;
    }

    public boolean removeOnCancelListener(DialogInterface$OnCancelListener arg1) {
        return this.onCancelListeners.remove(arg1);
    }

    public boolean removeOnDismissListener(DialogInterface$OnDismissListener arg1) {
        return this.onDismissListeners.remove(arg1);
    }

    public boolean removeOnNegativeButtonClickListener(View$OnClickListener arg1) {
        return this.onNegativeButtonClickListeners.remove(arg1);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener arg1) {
        return this.onPositiveButtonClickListeners.remove(arg1);
    }

    private void startPickerFragment() {
        MaterialTextInputPicker v1_1;
        int v0 = this.getThemeResId(this.requireContext());
        MaterialCalendar v1 = MaterialCalendar.newInstance(this.getDateSelector(), v0, this.calendarConstraints, this.dayViewDecorator);
        this.calendar = v1;
        if(this.inputMode == 1) {
            v1_1 = MaterialTextInputPicker.newInstance(this.getDateSelector(), v0, this.calendarConstraints);
        }

        this.pickerFragment = ((PickerFragment)v1_1);
        this.updateTitle();
        this.updateHeader(this.getHeaderText());
        FragmentTransaction v0_1 = this.getChildFragmentManager().beginTransaction();
        v0_1.replace(id.mtrl_calendar_frame, this.pickerFragment);
        v0_1.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener() {
            public void onIncompleteSelectionChanged() {
                MaterialDatePicker.this.confirmButton.setEnabled(false);
            }

            public void onSelectionChanged(Object arg2) {
                MaterialDatePicker.this.updateHeader(MaterialDatePicker.this.getHeaderText());
                MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.getDateSelector().isSelectionComplete());
            }
        });
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    void updateHeader(String arg3) {
        this.headerSelectionText.setContentDescription(this.getHeaderContentDescription());
        this.headerSelectionText.setText(((CharSequence)arg3));
    }

    private void updateTitle() {
        TextView v0 = this.headerTitleTextView;
        CharSequence v3 = this.inputMode != 1 || !this.isLandscape() ? this.fullTitleText : this.singleLineTitleText;
        v0.setText(v3);
    }

    private void updateToggleContentDescription(CheckableImageButton arg3) {
        String v3 = this.inputMode == 1 ? arg3.getContext().getString(string.mtrl_picker_toggle_to_calendar_input_mode) : arg3.getContext().getString(string.mtrl_picker_toggle_to_text_input_mode);
        this.headerToggleButton.setContentDescription(((CharSequence)v3));
    }
}

