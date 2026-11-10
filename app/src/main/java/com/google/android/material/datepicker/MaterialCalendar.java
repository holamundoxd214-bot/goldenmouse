package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

public final class MaterialCalendar extends PickerFragment {
    enum CalendarSelector {
        public static final enum CalendarSelector DAY;
        public static final enum CalendarSelector YEAR;

        static {
            CalendarSelector v0 = new CalendarSelector("DAY", 0);
            CalendarSelector.DAY = v0;
            CalendarSelector v1 = new CalendarSelector("YEAR", 1);
            CalendarSelector.YEAR = v1;
            CalendarSelector.$VALUES = new CalendarSelector[]{v0, v1};
        }

        private CalendarSelector(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static CalendarSelector valueOf(String arg1) {
            return Enum.valueOf(CalendarSelector.class, arg1);
        }

        public static CalendarSelector[] values() {
            return CalendarSelector.$VALUES.clone();
        }
    }

    interface OnDayClickListener {
        void onDayClick(long arg1);
    }

    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    static final Object MONTHS_VIEW_GROUP_TAG = null;
    static final Object NAVIGATION_NEXT_TAG = null;
    static final Object NAVIGATION_PREV_TAG = null;
    static final Object SELECTOR_TOGGLE_TAG = null;
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private CalendarConstraints calendarConstraints;
    private CalendarSelector calendarSelector;
    private CalendarStyle calendarStyle;
    private Month current;
    private DateSelector dateSelector;
    private View dayFrame;
    private DayViewDecorator dayViewDecorator;
    private View monthNext;
    private View monthPrev;
    private RecyclerView recyclerView;
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    static {
        MaterialCalendar.MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
        MaterialCalendar.NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
        MaterialCalendar.NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
        MaterialCalendar.SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    }

    public MaterialCalendar() {
        super();
    }

    static RecyclerView access$000(MaterialCalendar arg0) {
        return arg0.recyclerView;
    }

    static CalendarConstraints access$100(MaterialCalendar arg0) {
        return arg0.calendarConstraints;
    }

    static DateSelector access$200(MaterialCalendar arg0) {
        return arg0.dateSelector;
    }

    static RecyclerView access$300(MaterialCalendar arg0) {
        return arg0.yearSelector;
    }

    static CalendarStyle access$400(MaterialCalendar arg0) {
        return arg0.calendarStyle;
    }

    static View access$500(MaterialCalendar arg0) {
        return arg0.dayFrame;
    }

    static Month access$602(MaterialCalendar arg0, Month arg1) {
        arg0.current = arg1;
        return arg1;
    }

    private void addActionsToMonthNavigation(View arg4, MonthsPagerAdapter arg5) {
        View v0 = arg4.findViewById(id.month_navigation_fragment_toggle);
        ((MaterialButton)v0).setTag(MaterialCalendar.SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(v0, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                int v1 = MaterialCalendar.this.dayFrame.getVisibility();
                MaterialCalendar v0 = MaterialCalendar.this;
                String v0_1 = v1 == 0 ? v0.getString(string.mtrl_picker_toggle_to_year_selection) : v0.getString(string.mtrl_picker_toggle_to_day_selection);
                arg2.setHintText(((CharSequence)v0_1));
            }
        });
        View v1 = arg4.findViewById(id.month_navigation_previous);
        this.monthPrev = v1;
        v1.setTag(MaterialCalendar.NAVIGATION_PREV_TAG);
        v1 = arg4.findViewById(id.month_navigation_next);
        this.monthNext = v1;
        v1.setTag(MaterialCalendar.NAVIGATION_NEXT_TAG);
        this.yearFrame = arg4.findViewById(id.mtrl_calendar_year_selector_frame);
        this.dayFrame = arg4.findViewById(id.mtrl_calendar_day_selector_frame);
        this.setSelector(CalendarSelector.DAY);
        ((MaterialButton)v0).setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new OnScrollListener(arg5, ((MaterialButton)v0)) {
            public void onScrollStateChanged(RecyclerView arg1, int arg2) {
                if(arg2 == 0) {
                    arg1.announceForAccessibility(this.val$monthDropSelect.getText());
                }
            }

            public void onScrolled(RecyclerView arg1, int arg2, int arg3) {
                MaterialCalendar v1 = MaterialCalendar.this;
                int v1_1 = arg2 < 0 ? v1.getLayoutManager().findFirstVisibleItemPosition() : v1.getLayoutManager().findLastVisibleItemPosition();
                MaterialCalendar.this.current = this.val$monthsPagerAdapter.getPageMonth(v1_1);
                this.val$monthDropSelect.setText(this.val$monthsPagerAdapter.getPageTitle(v1_1));
            }
        });
        ((MaterialButton)v0).setOnClickListener(new View$OnClickListener() {
            public void onClick(View arg1) {
                MaterialCalendar.this.toggleVisibleSelector();
            }
        });
        this.monthNext.setOnClickListener(new View$OnClickListener(arg5) {
            public void onClick(View arg2) {
                int v2 = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
                if(v2 < MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                    MaterialCalendar.this.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(v2));
                }
            }
        });
        this.monthPrev.setOnClickListener(new View$OnClickListener(arg5) {
            public void onClick(View arg2) {
                int v2 = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
                if(v2 >= 0) {
                    MaterialCalendar.this.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(v2));
                }
            }
        });
    }

    public boolean addOnSelectionChangedListener(OnSelectionChangedListener arg1) {
        return super.addOnSelectionChangedListener(arg1);
    }

    private ItemDecoration createItemDecoration() {
        return new ItemDecoration() {
            private final Calendar endItem;
            private final Calendar startItem;

            public void onDraw(Canvas arg20, RecyclerView arg21, State arg22) {
                Object v4;
                com.google.android.material.datepicker.MaterialCalendar$5 v0 = this;
                if((arg21.getAdapter() instanceof YearGridAdapter)) {
                    if(!(arg21.getLayoutManager() instanceof GridLayoutManager)) {
                    }
                    else {
                        Adapter v1 = arg21.getAdapter();
                        LayoutManager v2 = arg21.getLayoutManager();
                        Iterator v3 = v0.this$0.dateSelector.getSelectedRanges().iterator();
                        while(true) {
                        label_14:
                            if(v3.hasNext()) {
                                v4 = v3.next();
                                if(((Pair)v4).first == null) {
                                    continue;
                                }

                                if(((Pair)v4).second == null) {
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }

                            return;
                        }

                        v0.startItem.setTimeInMillis(((Pair)v4).first.longValue());
                        v0.endItem.setTimeInMillis(((Pair)v4).second.longValue());
                        int v4_1 = ((YearGridAdapter)v1).getPositionForYear(v0.startItem.get(1));
                        int v5 = ((YearGridAdapter)v1).getPositionForYear(v0.endItem.get(1));
                        View v6 = ((GridLayoutManager)v2).findViewByPosition(v4_1);
                        View v7 = ((GridLayoutManager)v2).findViewByPosition(v5);
                        v4_1 /= ((GridLayoutManager)v2).getSpanCount();
                        v5 /= ((GridLayoutManager)v2).getSpanCount();
                        int v8;
                        for(v8 = v4_1; true; ++v8) {
                            if(v8 > v5) {
                                goto label_14;
                            }

                            View v9 = ((GridLayoutManager)v2).findViewByPosition(((GridLayoutManager)v2).getSpanCount() * v8);
                            if(v9 == null) {
                            }
                            else {
                                int v10 = v9.getTop() + v0.this$0.calendarStyle.year.getTopInset();
                                int v9_1 = v9.getBottom() - v0.this$0.calendarStyle.year.getBottomInset();
                                int v11 = v8 != v4_1 || v6 == null ? 0 : v6.getLeft() + v6.getWidth() / 2;
                                int v12 = v8 != v5 || v7 == null ? arg21.getWidth() : v7.getLeft() + v7.getWidth() / 2;
                                arg20.drawRect(((float)v11), ((float)v10), ((float)v12), ((float)v9_1), v0.this$0.calendarStyle.rangeFill);
                            }
                        }
                    }
                }
            }
        };
    }

    CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    Month getCurrentMonth() {
        return this.current;
    }

    public DateSelector getDateSelector() {
        return this.dateSelector;
    }

    static int getDayHeight(Context arg1) {
        return arg1.getResources().getDimensionPixelSize(dimen.mtrl_calendar_day_height);
    }

    private static int getDialogPickerHeight(Context arg5) {
        Resources v5 = arg5.getResources();
        return v5.getDimensionPixelSize(dimen.mtrl_calendar_navigation_height) + v5.getDimensionPixelOffset(dimen.mtrl_calendar_navigation_top_padding) + v5.getDimensionPixelOffset(dimen.mtrl_calendar_navigation_bottom_padding) + v5.getDimensionPixelSize(dimen.mtrl_calendar_days_of_week_height) + (MonthAdapter.MAXIMUM_WEEKS * v5.getDimensionPixelSize(dimen.mtrl_calendar_day_height) + (MonthAdapter.MAXIMUM_WEEKS - 1) * v5.getDimensionPixelOffset(dimen.mtrl_calendar_month_vertical_padding)) + v5.getDimensionPixelOffset(dimen.mtrl_calendar_bottom_padding);
    }

    LinearLayoutManager getLayoutManager() {
        return this.recyclerView.getLayoutManager();
    }

    public static MaterialCalendar newInstance(DateSelector arg1, int arg2, CalendarConstraints arg3) {
        return MaterialCalendar.newInstance(arg1, arg2, arg3, null);
    }

    public static MaterialCalendar newInstance(DateSelector arg3, int arg4, CalendarConstraints arg5, DayViewDecorator arg6) {
        MaterialCalendar v0 = new MaterialCalendar();
        Bundle v1 = new Bundle();
        v1.putInt("THEME_RES_ID_KEY", arg4);
        v1.putParcelable("GRID_SELECTOR_KEY", ((Parcelable)arg3));
        v1.putParcelable("CALENDAR_CONSTRAINTS_KEY", ((Parcelable)arg5));
        v1.putParcelable("DAY_VIEW_DECORATOR_KEY", ((Parcelable)arg6));
        v1.putParcelable("CURRENT_MONTH_KEY", arg5.getOpenAt());
        v0.setArguments(v1);
        return v0;
    }

    public void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        if(arg2 == null) {
            arg2 = this.getArguments();
        }

        this.themeResId = arg2.getInt("THEME_RES_ID_KEY");
        this.dateSelector = arg2.getParcelable("GRID_SELECTOR_KEY");
        this.calendarConstraints = arg2.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.dayViewDecorator = arg2.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.current = arg2.getParcelable("CURRENT_MONTH_KEY");
    }

    public View onCreateView(LayoutInflater arg11, ViewGroup arg12, Bundle arg13) {
        int v5;
        int v3;
        ContextThemeWrapper v6 = new ContextThemeWrapper(this.getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(((Context)v6));
        LayoutInflater v0 = arg11.cloneInContext(((Context)v6));
        Month v2 = this.calendarConstraints.getStart();
        if(MaterialDatePicker.isFullscreen(((Context)v6))) {
            v3 = layout.mtrl_calendar_vertical;
            v5 = 1;
        }
        else {
            v3 = layout.mtrl_calendar_horizontal;
            v5 = 0;
        }

        View v9 = v0.inflate(v3, arg12, false);
        v9.setMinimumHeight(MaterialCalendar.getDialogPickerHeight(this.requireContext()));
        View v0_1 = v9.findViewById(id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(v0_1, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                arg2.setCollectionInfo(null);
            }
        });
        v3 = this.calendarConstraints.getFirstDayOfWeek();
        DaysOfWeekAdapter v4 = v3 > 0 ? new DaysOfWeekAdapter(v3) : new DaysOfWeekAdapter();
        ((GridView)v0_1).setAdapter(((ListAdapter)v4));
        ((GridView)v0_1).setNumColumns(v2.daysInWeek);
        ((GridView)v0_1).setEnabled(false);
        this.recyclerView = v9.findViewById(id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new SmoothCalendarLayoutManager(this.getContext(), v5, false, v5) {
            protected void calculateExtraLayoutSpace(State arg4, int[] arg5) {
                int v4 = this.val$orientation;
                MaterialCalendar v0 = MaterialCalendar.this;
                if(v4 == 0) {
                    arg5[0] = v0.recyclerView.getWidth();
                    arg5[1] = MaterialCalendar.this.recyclerView.getWidth();
                    return;
                }

                arg5[0] = v0.recyclerView.getHeight();
                arg5[1] = MaterialCalendar.this.recyclerView.getHeight();
            }
        });
        this.recyclerView.setTag(MaterialCalendar.MONTHS_VIEW_GROUP_TAG);
        ContextThemeWrapper v1 = v6;
        MonthsPagerAdapter v0_2 = new MonthsPagerAdapter(((Context)v1), this.dateSelector, this.calendarConstraints, this.dayViewDecorator, new OnDayClickListener() {
            public void onDayClick(long arg2) {
                if(MaterialCalendar.this.calendarConstraints.getDateValidator().isValid(arg2)) {
                    MaterialCalendar.this.dateSelector.select(arg2);
                    Iterator v2 = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                    while(v2.hasNext()) {
                        v2.next().onSelectionChanged(MaterialCalendar.this.dateSelector.getSelection());
                    }

                    MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
                    if(MaterialCalendar.this.yearSelector != null) {
                        MaterialCalendar.this.yearSelector.getAdapter().notifyDataSetChanged();
                    }
                }
            }
        });
        this.recyclerView.setAdapter(((Adapter)v0_2));
        int v2_1 = v1.getResources().getInteger(integer.mtrl_calendar_year_selector_span);
        View v3_1 = v9.findViewById(id.mtrl_calendar_year_selector_frame);
        this.yearSelector = ((RecyclerView)v3_1);
        if(v3_1 != null) {
            ((RecyclerView)v3_1).setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager(((Context)v1), v2_1, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(this.createItemDecoration());
        }

        if(v9.findViewById(id.month_navigation_fragment_toggle) != null) {
            this.addActionsToMonthNavigation(v9, v0_2);
        }

        if(!MaterialDatePicker.isFullscreen(((Context)v1))) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }

        this.recyclerView.scrollToPosition(v0_2.getPosition(this.current));
        this.setUpForAccessibility();
        return v9;
    }

    public void onSaveInstanceState(Bundle arg3) {
        super.onSaveInstanceState(arg3);
        arg3.putInt("THEME_RES_ID_KEY", this.themeResId);
        arg3.putParcelable("GRID_SELECTOR_KEY", this.dateSelector);
        arg3.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        arg3.putParcelable("DAY_VIEW_DECORATOR_KEY", this.dayViewDecorator);
        arg3.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    private void postSmoothRecyclerViewScroll(int arg3) {
        this.recyclerView.post(new Runnable(arg3) {
            public void run() {
                MaterialCalendar.this.recyclerView.smoothScrollToPosition(this.val$position);
            }
        });
    }

    void setCurrentMonth(Month arg7) {
        Adapter v0 = this.recyclerView.getAdapter();
        int v1 = ((MonthsPagerAdapter)v0).getPosition(arg7);
        int v0_1 = v1 - ((MonthsPagerAdapter)v0).getPosition(this.current);
        int v4 = 1;
        int v2 = Math.abs(v0_1) > 3 ? 1 : 0;
        if(v0_1 > 0) {
        }
        else {
            v4 = 0;
        }

        this.current = arg7;
        if(v2 != 0 && v4 != 0) {
            this.recyclerView.scrollToPosition(v1 - 3);
            this.postSmoothRecyclerViewScroll(v1);
            return;
        }

        if(v2 != 0) {
            this.recyclerView.scrollToPosition(v1 + 3);
            this.postSmoothRecyclerViewScroll(v1);
            return;
        }

        this.postSmoothRecyclerViewScroll(v1);
    }

    void setSelector(CalendarSelector arg5) {
        this.calendarSelector = arg5;
        int v1 = 8;
        if(arg5 == CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(this.yearSelector.getAdapter().getPositionForYear(this.current.year));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(v1);
            this.monthPrev.setVisibility(v1);
            this.monthNext.setVisibility(v1);
            return;
        }

        if(arg5 == CalendarSelector.DAY) {
            this.yearFrame.setVisibility(v1);
            this.dayFrame.setVisibility(0);
            this.monthPrev.setVisibility(0);
            this.monthNext.setVisibility(0);
            this.setCurrentMonth(this.current);
        }
    }

    private void setUpForAccessibility() {
        ViewCompat.setAccessibilityDelegate(this.recyclerView, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                arg2.setScrollable(false);
            }
        });
    }

    void toggleVisibleSelector() {
        if(this.calendarSelector == CalendarSelector.YEAR) {
            this.setSelector(CalendarSelector.DAY);
            return;
        }

        if(this.calendarSelector == CalendarSelector.DAY) {
            this.setSelector(CalendarSelector.YEAR);
        }
    }
}

