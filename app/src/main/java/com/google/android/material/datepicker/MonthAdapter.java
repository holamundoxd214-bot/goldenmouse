package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.google.android.material.R$layout;
import java.util.Collection;
import java.util.Iterator;

class MonthAdapter extends BaseAdapter {
    private static final int MAXIMUM_GRID_CELLS = 0;
    static final int MAXIMUM_WEEKS = 0;
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector dateSelector;
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection previouslySelectedDates;

    static {
        MonthAdapter.MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
        MonthAdapter.MAXIMUM_GRID_CELLS = UtcDates.getUtcCalendar().getMaximum(5) + UtcDates.getUtcCalendar().getMaximum(7) - 1;
    }

    MonthAdapter(Month arg1, DateSelector arg2, CalendarConstraints arg3, DayViewDecorator arg4) {
        super();
        this.month = arg1;
        this.dateSelector = arg2;
        this.calendarConstraints = arg3;
        this.dayViewDecorator = arg4;
        this.previouslySelectedDates = arg2.getSelectedDays();
    }

    int dayToPosition(int arg1) {
        return this.firstPositionInMonth() + (arg1 - 1);
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    public int getCount() {
        return MonthAdapter.MAXIMUM_GRID_CELLS;
    }

    private String getDayContentDescription(Context arg7, long arg8) {
        return DateStrings.getDayContentDescription(arg7, arg8, this.isToday(arg8), this.isStartOfRange(arg8), this.isEndOfRange(arg8));
    }

    public Long getItem(int arg2) {
        if(arg2 >= this.firstPositionInMonth()) {
            if(arg2 > this.lastPositionInMonth()) {
            }
            else {
                return Long.valueOf(this.month.getDay(this.positionToDay(arg2)));
            }
        }

        return null;
    }

    public Object getItem(int arg1) {
        return this.getItem(arg1);
    }

    public long getItemId(int arg1) {
        return ((long)(arg1 / this.month.daysInWeek));
    }

    public View getView(int arg1, View arg2, ViewGroup arg3) {
        return this.getView(arg1, arg2, arg3);
    }

    public TextView getView(int arg6, View arg7, ViewGroup arg8) {
        this.initializeStyles(arg8.getContext());
        View v0 = arg7;
        if(arg7 == null) {
            v0 = LayoutInflater.from(arg8.getContext()).inflate(layout.mtrl_calendar_day, arg8, false);
        }

        int v7 = arg6 - this.firstPositionInMonth();
        if(v7 < 0 || v7 >= this.month.daysInMonth) {
            ((TextView)v0).setVisibility(8);
            ((TextView)v0).setEnabled(false);
            v7 = -1;
        }
        else {
            ++v7;
            ((TextView)v0).setTag(this.month);
            ((TextView)v0).setText(String.format(((TextView)v0).getResources().getConfiguration().locale, "%d", Integer.valueOf(v7)));
            ((TextView)v0).setVisibility(0);
            ((TextView)v0).setEnabled(true);
        }

        Long v6 = this.getItem(arg6);
        if(v6 == null) {
            return ((TextView)v0);
        }

        this.updateSelectedState(((TextView)v0), v6.longValue(), v7);
        return ((TextView)v0);
    }

    public boolean hasStableIds() {
        return 1;
    }

    private void initializeStyles(Context arg2) {
        if(this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(arg2);
        }
    }

    boolean isEndOfRange(long arg3) {
        Iterator v2 = this.dateSelector.getSelectedRanges().iterator();
        do {
        label_3:
            if(!v2.hasNext()) {
                return 0;
            }

            Object v0 = v2.next();
            if(((Pair)v0).second == null) {
                goto label_3;
            }
        }
        while(((Pair)v0).second.longValue() != arg3);

        return 1;
    }

    boolean isFirstInRow(int arg1) {
        if(arg1 % this.month.daysInWeek == 0) {
            return 1;
        }

        return 0;
    }

    boolean isLastInRow(int arg2) {
        if((arg2 + 1) % this.month.daysInWeek == 0) {
            return 1;
        }

        return 0;
    }

    private boolean isSelected(long arg5) {
        Iterator v4 = this.dateSelector.getSelectedDays().iterator();
        do {
            if(!v4.hasNext()) {
                return 0;
            }
        }
        while(UtcDates.canonicalYearMonthDay(arg5) != UtcDates.canonicalYearMonthDay(v4.next().longValue()));

        return 1;
    }

    boolean isStartOfRange(long arg3) {
        Iterator v2 = this.dateSelector.getSelectedRanges().iterator();
        do {
        label_3:
            if(!v2.hasNext()) {
                return 0;
            }

            Object v0 = v2.next();
            if(((Pair)v0).first == null) {
                goto label_3;
            }
        }
        while(((Pair)v0).first.longValue() != arg3);

        return 1;
    }

    private boolean isToday(long arg3) {
        if(UtcDates.getTodayCalendar().getTimeInMillis() == arg3) {
            return 1;
        }

        return 0;
    }

    int lastPositionInMonth() {
        return this.firstPositionInMonth() + this.month.daysInMonth - 1;
    }

    int positionToDay(int arg1) {
        return arg1 - this.firstPositionInMonth() + 1;
    }

    private void updateSelectedState(TextView arg9, long arg10, int arg12) {
        CalendarItemStyle v10;
        boolean v0;
        if(arg9 == null) {
            return;
        }

        Context v1 = arg9.getContext();
        String v7 = this.getDayContentDescription(v1, arg10);
        arg9.setContentDescription(((CharSequence)v7));
        boolean v5 = this.calendarConstraints.getDateValidator().isValid(arg10);
        if(v5) {
            arg9.setEnabled(true);
            v0 = this.isSelected(arg10);
            arg9.setSelected(v0);
            if(v0) {
                v10 = this.calendarStyle.selectedDay;
            }
            else {
                boolean v10_1 = this.isToday(arg10);
                CalendarStyle v11 = this.calendarStyle;
                v10 = v10_1 ? v11.todayDay : v11.day;
            }
        }
        else {
            v0 = false;
            arg9.setEnabled(false);
            v10 = this.calendarStyle.invalidDay;
        }

        boolean v6 = v0;
        if(this.dayViewDecorator != null && arg12 != -1) {
            int v2 = this.month.year;
            int v3 = this.month.month;
            v10.styleItem(arg9, this.dayViewDecorator.getBackgroundColor(v1, v2, v3, arg12, v5, v6), this.dayViewDecorator.getTextColor(v1, v2, v3, arg12, v5, v6));
            arg9.setCompoundDrawables(this.dayViewDecorator.getCompoundDrawableLeft(v1, v2, v3, arg12, v5, v6), this.dayViewDecorator.getCompoundDrawableTop(v1, v2, v3, arg12, v5, v6), this.dayViewDecorator.getCompoundDrawableRight(v1, v2, v3, arg12, v5, v6), this.dayViewDecorator.getCompoundDrawableBottom(v1, v2, v3, arg12, v5, v6));
            arg9.setContentDescription(this.dayViewDecorator.getContentDescription(v1, v2, v3, arg12, v5, v6, ((CharSequence)v7)));
            return;
        }

        v10.styleItem(arg9);
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView arg4, long arg5) {
        if(Month.create(arg5).equals(this.month)) {
            int v0 = this.month.getDayOfMonth(arg5);
            this.updateSelectedState(arg4.getChildAt(arg4.getAdapter().dayToPosition(v0) - arg4.getFirstVisiblePosition()), arg5, v0);
        }
    }

    public void updateSelectedStates(MaterialCalendarGridView arg4) {
        Iterator v0 = this.previouslySelectedDates.iterator();
        while(v0.hasNext()) {
            this.updateSelectedStateForDate(arg4, v0.next().longValue());
        }

        DateSelector v0_1 = this.dateSelector;
        if(v0_1 != null) {
            v0 = v0_1.getSelectedDays().iterator();
            while(v0.hasNext()) {
                this.updateSelectedStateForDate(arg4, v0.next().longValue());
            }

            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    boolean withinMonth(int arg2) {
        if(arg2 >= this.firstPositionInMonth() && arg2 <= this.lastPositionInMonth()) {
            return 1;
        }

        return 0;
    }
}

