package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE = 0;
    private static final int NARROW_FORMAT = 4;
    private final Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    static {
        DaysOfWeekAdapter.CALENDAR_DAY_STYLE = 4;
    }

    public DaysOfWeekAdapter() {
        super();
        Calendar v0 = UtcDates.getUtcCalendar();
        this.calendar = v0;
        this.daysInWeek = v0.getMaximum(7);
        this.firstDayOfWeek = v0.getFirstDayOfWeek();
    }

    public DaysOfWeekAdapter(int arg3) {
        super();
        Calendar v0 = UtcDates.getUtcCalendar();
        this.calendar = v0;
        this.daysInWeek = v0.getMaximum(7);
        this.firstDayOfWeek = arg3;
    }

    public int getCount() {
        return this.daysInWeek;
    }

    public Integer getItem(int arg2) {
        if(arg2 >= this.daysInWeek) {
            return null;
        }

        return Integer.valueOf(this.positionToDayOfWeek(arg2));
    }

    public Object getItem(int arg1) {
        return this.getItem(arg1);
    }

    public long getItemId(int arg1) {
        return 0;
    }

    public View getView(int arg4, View arg5, ViewGroup arg6) {
        View v0 = arg5;
        if(arg5 == null) {
            v0 = LayoutInflater.from(arg6.getContext()).inflate(layout.mtrl_calendar_day_of_week, arg6, false);
        }

        this.calendar.set(7, this.positionToDayOfWeek(arg4));
        ((TextView)v0).setText(this.calendar.getDisplayName(7, DaysOfWeekAdapter.CALENDAR_DAY_STYLE, ((TextView)v0).getResources().getConfiguration().locale));
        ((TextView)v0).setContentDescription(String.format(arg6.getContext().getString(string.mtrl_picker_day_of_week_column_header), this.calendar.getDisplayName(7, 2, Locale.getDefault())));
        return v0;
    }

    private int positionToDayOfWeek(int arg2) {
        arg2 += this.firstDayOfWeek;
        int v1 = this.daysInWeek;
        if(arg2 > v1) {
            arg2 -= v1;
        }

        return arg2;
    }
}

